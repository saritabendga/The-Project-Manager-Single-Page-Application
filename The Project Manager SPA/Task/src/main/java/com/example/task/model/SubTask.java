package com.example.task.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subtasks")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subtaskId;
    private long id;
    private String subtaskName;
    private String subtaskDesc;
    private LocalDateTime createdOn;

    public SubTask() {
    }

    public SubTask(int subtaskId, long id, String subtaskName, String subtaskDesc, LocalDateTime createdOn) {
        this.subtaskId = subtaskId;
        this.id = id;
        this.subtaskName = subtaskName;
        this.subtaskDesc = subtaskDesc;
        this.createdOn = createdOn;
    }

    public int getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public String getSubtaskDesc() {
        return subtaskDesc;
    }

    public void setSubtaskDesc(String subtaskDesc) {
        this.subtaskDesc = subtaskDesc;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}