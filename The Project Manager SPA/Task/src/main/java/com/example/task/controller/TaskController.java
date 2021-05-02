package com.example.task.controller;


import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

     @Autowired
    TaskService taskService;

     @Autowired
    TaskRepository taskRepository;



    @GetMapping("tasksByStatus/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable boolean status)
    {
        return taskService.findAllByCompleted(status);
    }
}
