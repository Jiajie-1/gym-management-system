package com.example.gym.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Course name
    @Column(nullable = false)
    private String name;

    // Course type: ONE_TO_ONE or GROUP
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseType type;

    // Course start time
    private LocalDateTime startTime;

    // Max capacity for GROUP courses
    private Integer capacity;
}