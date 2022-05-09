package com.blog.controller;

import java.util.List;
import java.util.Map;

import javax.xml.bind.Unmarshaller.Listener;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entites.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    // Post - to create User
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto dto = this.userService.createUser(userDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // Get - to get All user
    @GetMapping("/getUser")
    public ResponseEntity<List<UserDto>> getAll()
    {
        List<UserDto> dto = this.userService.getAllUsers();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Get - to get user by Id
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){

        UserDto dto = this.userService.getUserById(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

     //Put - to Update user by Id
     @GetMapping("/updateUser/{id}")
     public ResponseEntity<UserDto> updateById(@RequestBody UserDto dto1,@PathVariable Long id){
 
         UserDto dto = this.userService.updateUser(dto1, id);
 
         return new ResponseEntity<>(dto, HttpStatus.OK);
     }

      //Delete - to delete user by Id
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserDto> deleteById(@PathVariable Long id){

         this.userService.deleteUser(id);

        // return new ResponseEntity(Map.of("message","User deleted successfully"),HttpStatus.OK);
       return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
    }

}
