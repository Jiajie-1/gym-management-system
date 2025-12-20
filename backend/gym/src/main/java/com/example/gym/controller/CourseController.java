package com.example.gym.controller;

import com.example.gym.dto.CreateCourseRequestDTO;
import com.example.gym.dto.CourseResponseDTO;
import com.example.gym.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public CourseResponseDTO createCourse(@Valid @RequestBody CreateCourseRequestDTO dto) {
        return courseService.createCourse(dto);
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }
}
