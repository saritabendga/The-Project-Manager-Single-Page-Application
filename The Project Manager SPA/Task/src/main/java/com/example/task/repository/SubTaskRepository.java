package com.example.task.repository;

import com.example.task.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubTaskRepository extends JpaRepository<SubTask, Integer> {

}
