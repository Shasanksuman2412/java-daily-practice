package com.javadailypractice.taskmanager;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Only the fields a client is ALLOWED to provide when creating a task.
// Notice there's no "id" or "completed" field here - clients can't set an
// id (that's server-generated) or mark a brand-new task as already done.
public record CreateTaskRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title must be under 100 characters")
        String title
) {
}
