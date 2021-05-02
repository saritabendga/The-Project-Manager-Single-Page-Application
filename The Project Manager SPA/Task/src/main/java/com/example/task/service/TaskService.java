package com.example.task.service;

import com.example.task.model.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    public ResponseEntity<List<Task>> findAllByCompleted(boolean taskIsCompleted);
    public ResponseEntity<List<Task>> findAllByTaskName(String taskName);

    void updateTask(Task task);
    void deleteTask(Task task);
    void deleteTaskById(Long id);
    void addTask(Task task);
}
