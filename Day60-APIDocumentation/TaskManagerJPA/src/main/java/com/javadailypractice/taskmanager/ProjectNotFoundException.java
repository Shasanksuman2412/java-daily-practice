package com.javadailypractice.taskmanager;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(int id) {
        super("Project not found with id: " + id);
    }
}
