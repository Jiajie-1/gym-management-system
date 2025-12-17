package com.example.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class UserUpdateDTO {
    private String username;
    private String email;
    private String password;
}
