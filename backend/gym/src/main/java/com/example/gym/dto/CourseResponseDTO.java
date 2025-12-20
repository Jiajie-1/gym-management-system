package com.example.gym.dto;

import com.example.gym.entity.CourseType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CourseResponseDTO {

    private Long id;
    private String title;
    private CourseType type;
    private LocalDateTime startTime;
    private Integer durationMinutes;
    private String trainerName;

}
