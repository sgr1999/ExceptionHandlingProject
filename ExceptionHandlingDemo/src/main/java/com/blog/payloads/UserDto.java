package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String about;

    

}
