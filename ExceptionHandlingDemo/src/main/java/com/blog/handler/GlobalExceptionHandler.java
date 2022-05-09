package com.blog.handler;

import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
    
    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

    // }
}
