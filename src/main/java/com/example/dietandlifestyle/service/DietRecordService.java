package com.example.dietandlifestyle.service;

import com.example.dietandlifestyle.entity.DietRecord;
import com.example.dietandlifestyle.repository.DietRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DietRecordService {
    
    @Autowired
    private DietRecordRepository dietRecordRepository;
    
    /**
     * Get all diet records
     */
    public List<DietRecord> getAllRecords() {
        return dietRecordRepository.findAll();
    }
    
    /**
     * Get a diet record by ID
     */
    public Optional<DietRecord> getRecordById(Long id) {
        return dietRecordRepository.findById(id);
    }
    
    /**
     * Get diet records by date
     */
    public List<DietRecord> getRecordsByDate(LocalDate date) {
        return dietRecordRepository.findByDate(date);
    }
    
    /**
     * Create a new diet record
     */
    public DietRecord createRecord(DietRecord dietRecord) {
        return dietRecordRepository.save(dietRecord);
    }
    
    /**
     * Update an existing diet record
     */
    public DietRecord updateRecord(Long id, DietRecord dietRecordDetails) {
        DietRecord dietRecord = dietRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet record not found with id: " + id));
        
        dietRecord.setFoodName(dietRecordDetails.getFoodName());
        dietRecord.setCalories(dietRecordDetails.getCalories());
        dietRecord.setMealType(dietRecordDetails.getMealType());
        dietRecord.setDate(dietRecordDetails.getDate());
        
        return dietRecordRepository.save(dietRecord);
    }
    
    /**
     * Delete a diet record by ID
     */
    public void deleteRecord(Long id) {
        DietRecord dietRecord = dietRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet record not found with id: " + id));
        dietRecordRepository.delete(dietRecord);
    }
}
