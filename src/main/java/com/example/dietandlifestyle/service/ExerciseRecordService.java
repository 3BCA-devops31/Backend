package com.example.dietandlifestyle.service;

import com.example.dietandlifestyle.entity.ExerciseRecord;
import com.example.dietandlifestyle.repository.ExerciseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseRecordService {

    @Autowired
    private ExerciseRecordRepository exerciseRecordRepository;

    public List<ExerciseRecord> getAll() {
        return exerciseRecordRepository.findAll();
    }

    public Optional<ExerciseRecord> getById(Long id) {
        return exerciseRecordRepository.findById(id);
    }

    public List<ExerciseRecord> getByDate(LocalDate date) {
        return exerciseRecordRepository.findByDate(date);
    }

    public ExerciseRecord create(ExerciseRecord exerciseRecord) {
        return exerciseRecordRepository.save(exerciseRecord);
    }

    public ExerciseRecord update(Long id, ExerciseRecord updated) {
        ExerciseRecord existing = exerciseRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise record not found with id: " + id));

        existing.setActivityName(updated.getActivityName());
        existing.setMinutes(updated.getMinutes());
        existing.setDate(updated.getDate());
        return exerciseRecordRepository.save(existing);
    }

    public void delete(Long id) {
        ExerciseRecord existing = exerciseRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise record not found with id: " + id));
        exerciseRecordRepository.delete(existing);
    }
}
