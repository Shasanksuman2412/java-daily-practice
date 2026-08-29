package com.javadailypractice.taskmanager;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(
        @NotBlank(message = "Project name is required")
        String name
) {
}
