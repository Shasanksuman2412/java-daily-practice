package com.javadailypractice.taskmanager;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be under 100 characters")
    private String title;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "project_id")
    // no @JsonBackReference needed anymore - this entity is never
    // serialized directly, only ever converted to a TaskDTO first
    private Project project;

    public Task() {
    }

    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
