package com.example.task.repository;


import com.example.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Integer> {


    public Iterable<Task> findAllByCompleted(boolean completed);
    public Iterable<Task> findAllByTaskName(String taskName);
    public void deleteTaskById(Long id);

}
