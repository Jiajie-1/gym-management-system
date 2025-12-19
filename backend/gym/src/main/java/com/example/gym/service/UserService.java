package com.example.gym.service;

import com.example.gym.dto.UserCreateDTO;
import com.example.gym.dto.UserResponseDTO;
import com.example.gym.dto.UserUpdateDTO;
import com.example.gym.entity.Role;
import com.example.gym.entity.User;
import com.example.gym.exception.ResourceNotFoundException;
import com.example.gym.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public UserResponseDTO createUser(UserCreateDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword()); // 先明文，后面再加加密
        user.setEmail(dto.getEmail());
        user.setRole(Role.MEMBER);

        User saved = userRepository.save(user);
        return toResponseDTO(saved);
    }

    // READ ONE
    public UserResponseDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toResponseDTO(user);
    }

    // READ ALL
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // UPDATE
    public UserResponseDTO updateUser(Long id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));


        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        User updated = userRepository.save(user);
        return toResponseDTO(updated);
    }

    // DELETE
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    // ===== DTO Mapper（Junior 级完全够用）=====
    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
