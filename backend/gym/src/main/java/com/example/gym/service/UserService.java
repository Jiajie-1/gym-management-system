package com.example.gym.service;

import com.example.gym.dto.UserCreateDTO;
import com.example.gym.dto.UserResponseDTO;
import com.example.gym.dto.UserUpdateDTO;
import com.example.gym.entity.Role;
import com.example.gym.entity.User;
import com.example.gym.exception.ResourceNotFoundException;
import com.example.gym.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.gym.dto.TrainerDTO;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CREATE
    public UserResponseDTO createUser(UserCreateDTO dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        // Use provided role if present, otherwise default to MEMBER
        if (dto.getRole() != null) {
            user.setRole(dto.getRole());
        } else {
            user.setRole(Role.MEMBER);
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return toResponseDTO(userRepository.save(user));
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

    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    public Page<UserResponseDTO> getUsersPaged(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return userRepository.findAll(pageable)
                .map(this::toResponseDTO);
    }

    public Page<UserResponseDTO> getUsersPagedWithSearchAndSort(
            int page,
            int size,
            String keyword,
            String sortBy,
            String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);


        if (keyword == null || keyword.isBlank()) {
            return userRepository.findAll(pageable)
                    .map(this::toResponseDTO);
        }


        return userRepository
                .findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        keyword,
                        keyword,
                        pageable
                )
                .map(this::toResponseDTO);
    }

    // Fetch trainers for course scheduling dropdown
    public List<TrainerDTO> getAllTrainers() {
        return userRepository.findByRole(Role.TRAINER)
                .stream()
                .map(u -> new TrainerDTO(u.getId(), u.getUsername()))
                .toList();
    }

}
