package com.example.gym.dto;

import com.example.gym.entity.CourseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateCourseRequestDTO {

    @NotBlank
    private String title;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private Integer durationMinutes;

    @NotNull
    private CourseType type;

    @NotNull
    private Long trainerId;

    // --- getters ---
    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public CourseType getType() {
        return type;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    // --- setters ---
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
}
