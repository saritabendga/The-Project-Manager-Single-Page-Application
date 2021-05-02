package com.example.task.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "taskName", nullable = false, unique = true, length = 45)
    private String taskName;

    @Column(name = "taskDescription", nullable = false, length = 200)
    private String taskDesc;

    @Column(name = "startDate", nullable = false)
    private String startDate;

    @Column(name = "endDate", nullable = false)
    private String endDate;

    @Column(name = "task_status")
    private Boolean taskIsCompleted;


    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "Subtask")
    private List<SubTask> subtasks;

    public Task() {
    }

    public Task(Long id, String taskName, String taskDesc, String startDate, String endDate, Boolean taskIsCompleted) {
        this.id = id;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskIsCompleted = taskIsCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Boolean getTaskIsCompleted() {
        return taskIsCompleted;
    }

    public void setTaskIsCompleted(Boolean taskIsCompleted) {
        this.taskIsCompleted = taskIsCompleted;
    }
}