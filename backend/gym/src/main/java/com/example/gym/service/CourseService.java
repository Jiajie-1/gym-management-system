package com.example.gym.service;

import com.example.gym.entity.Course;
import com.example.gym.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Create course (Admin only)
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
