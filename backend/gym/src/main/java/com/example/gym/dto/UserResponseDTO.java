package com.example.gym.dto;

import com.example.gym.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class UserResponseDTO {
    private Long id;
    private  String username;
    private  String email;
    private Role role;
}
