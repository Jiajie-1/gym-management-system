package com.example.gym.controller;

import com.example.gym.dto.LoginRequestDTO;
import com.example.gym.dto.LoginResponseDTO;
import com.example.gym.entity.User;
import com.example.gym.repository.UserRepository;
import com.example.gym.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = JwtUtil.generateToken(user.getUsername());
        return new LoginResponseDTO(token);
    }
}
