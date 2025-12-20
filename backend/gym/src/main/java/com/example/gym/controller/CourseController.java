package com.example.gym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    // Temporary mock endpoint for frontend integration
    @GetMapping
    public List<Map<String, Object>> getAllCourses() {
        return List.of(
                Map.of(
                        "id", 1,
                        "name", "Personal Training",
                        "type", "ONE_TO_ONE",
                        "status", "AVAILABLE"
                ),
                Map.of(
                        "id", 2,
                        "name", "Yoga Group Class",
                        "type", "GROUP",
                        "status", "AVAILABLE"
                )
        );
    }
}
