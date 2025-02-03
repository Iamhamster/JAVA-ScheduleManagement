package com.example.schedule.repository;

import com.example.schedule.entity.ScheduleManagement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SmRepository {
    ScheduleManagement save(ScheduleManagement memo); //Create
    Optional<ScheduleManagement> findById(Long id); //Read
    List<ScheduleManagement> findAll(); //All Read
    ScheduleManagement update(Long id, String name, String todo, LocalDateTime updateTime); //Update
    void deleteById(Long id); //Delete
}
