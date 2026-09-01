package com.javadailypractice.taskmanager;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateTaskRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title must be under 100 characters")
        String title,
        boolean completed
) {
}
