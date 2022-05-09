package com.blog.services;

import java.util.List;

import com.blog.payloads.UserDto;

import org.springframework.stereotype.Service;


public interface UserService {
    
    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Long userId);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    void deleteUser(Long userId);
}
