package com.example.dietandlifestyle.entity;

import com.example.dietandlifestyle.enums.MealType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "diet_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String foodName;
    
    @Column(nullable = false)
    private Integer calories;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType mealType;
    
    @Column(nullable = false)
    private LocalDate date;
}
