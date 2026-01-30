package com.example.dietandlifestyle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "exercise_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String activityName;

    @Column(nullable = false)
    private Integer minutes;

    @Column(nullable = false)
    private LocalDate date;
}
