package com.example.gym.dto;

import com.example.gym.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    // Username for login
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20)
    private String username;

    // Raw password (will be encoded before saving)
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 20)
    private String password;

    // User email address
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email format is invalid")
    private String email;

    // Role assigned by admin (MEMBER / TRAINER / ADMIN)
    private Role role;
}
