package com.example.gym.controller;

import com.example.gym.dto.UserCreateDTO;
import com.example.gym.dto.UserResponseDTO;
import com.example.gym.dto.UserUpdateDTO;
import com.example.gym.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public UserResponseDTO create(@Valid @RequestBody UserCreateDTO dto) {
        return userService.createUser(dto);
    }

    // READ ONE
    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    // READ ALL
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserResponseDTO update(
            @PathVariable Long id,
            @RequestBody UserUpdateDTO dto
    ) {
        return userService.updateUser(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/page")
    public Page<UserResponseDTO> getUsersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return userService.getUsersPagedWithSearchAndSort(
                page, size, keyword, sortBy, direction
        );
    }
}
