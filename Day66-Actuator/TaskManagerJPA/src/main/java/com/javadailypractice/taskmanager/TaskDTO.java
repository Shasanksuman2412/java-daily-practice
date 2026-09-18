package com.javadailypractice.taskmanager;

public record TaskDTO(int id, String title, boolean completed, int projectId) {
}
