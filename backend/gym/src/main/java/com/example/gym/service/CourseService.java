package com.example.gym.service;

import com.example.gym.dto.CreateCourseRequestDTO;
import com.example.gym.dto.CourseResponseDTO;
import com.example.gym.entity.Course;
import com.example.gym.entity.Role;
import com.example.gym.entity.User;
import com.example.gym.repository.CourseRepository;
import com.example.gym.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository,
                         UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public CourseResponseDTO createCourse(CreateCourseRequestDTO dto) {

        User trainer = userRepository.findById(dto.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        if (trainer.getRole() != Role.TRAINER) {
            throw new RuntimeException("User is not a trainer");
        }

        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setStartTime(dto.getStartTime());
        course.setDurationMinutes(dto.getDurationMinutes());
        course.setType(dto.getType());
        course.setTrainer(trainer);

        return toDTO(courseRepository.save(course));
    }

    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private CourseResponseDTO toDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setType(course.getType());
        dto.setStartTime(course.getStartTime());
        dto.setDurationMinutes(course.getDurationMinutes());
        dto.setTrainerName(course.getTrainer().getUsername());
        return dto;
    }
}
