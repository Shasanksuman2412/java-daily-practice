package com.javadailypractice.taskmanager;

// The API's actual response shape for a Task - completely decoupled from
// the Task entity. No @ManyToOne, no JPA annotations, no risk of exposing
// internal fields or triggering lazy-loading issues.
public record TaskDTO(int id, String title, boolean completed, int projectId) {
}
