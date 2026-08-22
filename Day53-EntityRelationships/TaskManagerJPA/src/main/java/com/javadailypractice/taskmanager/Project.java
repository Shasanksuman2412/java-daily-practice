package com.javadailypractice.taskmanager;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Project name is required")
    private String name;

    // mappedBy = "project" tells JPA that Task.project is what actually
    // owns this relationship in the database - this side is just the
    // Java-level convenience view, no extra column is created here.
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // "forward" direction - INCLUDE tasks when serializing a Project
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
