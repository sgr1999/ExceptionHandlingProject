package com.blog.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.blog.dao.UserRepository;
import com.blog.entites.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = dtoToUser(userDto);
        User save = userRepository.save(user);
        return this.userToDto(save);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        
       User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
      
      user.setAbout(userDto.getAbout());
      user.setEmail(userDto.getEmail());
      user.setName(userDto.getName());
      user.setPassword(userDto.getPassword());
      user.setUserId(userDto.getUserId());

      User save = this.userRepository.save(user);
      UserDto dto = this.userToDto(user);

      return dto;
    }

    @Override
    public UserDto getUserById(Long userId) {
       
        User find = userRepository.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
       
        UserDto dto = this.userToDto(find);
       
        return dto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        
        List<User> users = userRepository.findAll();
        List<UserDto> dto = users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
       
        return dto;
    }

    @Override
    public void deleteUser(Long userId) {
        
        User user =userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));

        this.userRepository.delete(user);
    }

    public User dtoToUser(UserDto userDto) {

        User user = new User();

        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setUserId(userDto.getUserId());
        return user;
    }

    public UserDto userToDto(User user) {

        UserDto dto = new UserDto();

        dto.setAbout(user.getAbout());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setUserId(user.getUserId());
        return dto;
    }
}
