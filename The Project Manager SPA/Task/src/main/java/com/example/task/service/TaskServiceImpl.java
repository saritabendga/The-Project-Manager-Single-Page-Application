package com.example.task.service;


import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<List<Task>> findAllByCompleted(boolean taskIsCompleted) {
        List<Task> task = new ArrayList<>();
        for(Task t:taskRepository.findAllByCompleted(taskIsCompleted))
        {
            task.add(t);
        }
        return ResponseEntity.ok().body(task);
    }

    @Override
    public ResponseEntity<List<Task>> findAllByTaskName(String taskName) {
        List<Task> task = new ArrayList<>();
        for(Task t:taskRepository.findAllByTaskName(taskName))
        {
            task.add(t);
        }
        return ResponseEntity.ok().body(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteTaskById(id);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }
}