package com.example.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TrainerDTO {

    // Trainer identifier for dropdown selection
    private Long id;

    // Trainer display name for dropdown label
    private String username;
}
