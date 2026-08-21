package com.javadailypractice.taskmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // maps this class to a database table (named "task" by default)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment primary key
    private int id;

    private String title;
    private boolean completed;

    public Task() {
        // no-arg constructor required by JPA and by Jackson (for JSON deserialization)
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
}
