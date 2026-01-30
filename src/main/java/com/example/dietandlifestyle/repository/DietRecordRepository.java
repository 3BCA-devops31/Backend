package com.example.dietandlifestyle.repository;

import com.example.dietandlifestyle.entity.DietRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DietRecordRepository extends JpaRepository<DietRecord, Long> {
    
    List<DietRecord> findByDate(LocalDate date);
}
