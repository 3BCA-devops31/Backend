package com.example.dietandlifestyle.controller;

import com.example.dietandlifestyle.entity.DietRecord;
import com.example.dietandlifestyle.entity.ExerciseRecord;
import com.example.dietandlifestyle.service.DietRecordService;
import com.example.dietandlifestyle.service.ExerciseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/diet")
@CrossOrigin(origins = "*")
public class DietController {
    
    @Autowired
    private DietRecordService dietRecordService;

    @Autowired
    private ExerciseRecordService exerciseRecordService;
    
    /**
     * Get all diet records
     */
    @GetMapping
    public ResponseEntity<List<DietRecord>> getAllRecords() {
        List<DietRecord> records = dietRecordService.getAllRecords();
        return ResponseEntity.ok(records);
    }
    
    /**
     * Get a diet record by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<DietRecord> getRecordById(@PathVariable Long id) {
        return dietRecordService.getRecordById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Get diet records by date
     */
    @GetMapping("/date/{date}")
    public ResponseEntity<List<DietRecord>> getRecordsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<DietRecord> records = dietRecordService.getRecordsByDate(date);
        return ResponseEntity.ok(records);
    }
    
    /**
     * Create a new diet record
     */
    @PostMapping
    public ResponseEntity<DietRecord> createRecord(@RequestBody DietRecord dietRecord) {
        DietRecord createdRecord = dietRecordService.createRecord(dietRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }
    
    /**
     * Update an existing diet record
     */
    @PutMapping("/{id}")
    public ResponseEntity<DietRecord> updateRecord(
            @PathVariable Long id,
            @RequestBody DietRecord dietRecordDetails) {
        try {
            DietRecord updatedRecord = dietRecordService.updateRecord(id, dietRecordDetails);
            return ResponseEntity.ok(updatedRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Delete a diet record
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        try {
            dietRecordService.deleteRecord(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Aliases to match requested routes
    @PostMapping("/saveMeal")
    public ResponseEntity<DietRecord> saveMeal(@RequestBody DietRecord dietRecord) {
        DietRecord created = dietRecordService.createRecord(dietRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/deleteMeal/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        try {
            dietRecordService.deleteRecord(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Optional GET alias for delete links
    @GetMapping("/deleteMeal/{id}")
    public ResponseEntity<Void> deleteMealGet(@PathVariable Long id) {
        return deleteMeal(id);
    }

    /**
     * Get all exercise records
     */
    @GetMapping("/exercise")
    public ResponseEntity<List<ExerciseRecord>> getAllExerciseRecords() {
        List<ExerciseRecord> records = exerciseRecordService.getAll();
        return ResponseEntity.ok(records);
    }

    /**
     * Create a new exercise record
     */
    @PostMapping("/exercise")
    public ResponseEntity<ExerciseRecord> createExercise(@RequestBody ExerciseRecord exerciseRecord) {
        ExerciseRecord createdRecord = exerciseRecordService.create(exerciseRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    // Alias for requested route
    @PostMapping("/saveExercise")
    public ResponseEntity<ExerciseRecord> saveExercise(@RequestBody ExerciseRecord exerciseRecord) {
        ExerciseRecord createdRecord = exerciseRecordService.create(exerciseRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    /**
     * Update an existing exercise record
     */
    @PutMapping("/exercise/{id}")
    public ResponseEntity<ExerciseRecord> updateExercise(
            @PathVariable Long id,
            @RequestBody ExerciseRecord exerciseRecordDetails) {
        try {
            ExerciseRecord updatedRecord = exerciseRecordService.update(id, exerciseRecordDetails);
            return ResponseEntity.ok(updatedRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete an exercise record
     */
    @DeleteMapping("/exercise/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        try {
            exerciseRecordService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteExercise/{id}")
    public ResponseEntity<Void> deleteExerciseAlias(@PathVariable Long id) {
        try {
            exerciseRecordService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Optional GET alias for delete links
    @GetMapping("/deleteExercise/{id}")
    public ResponseEntity<Void> deleteExerciseGet(@PathVariable Long id) {
        return deleteExerciseAlias(id);
    }
}
