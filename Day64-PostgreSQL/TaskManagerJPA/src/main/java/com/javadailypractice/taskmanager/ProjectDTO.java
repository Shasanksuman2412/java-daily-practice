package com.javadailypractice.taskmanager;

import java.util.List;

// Includes the full list of TaskDTOs directly - no annotations needed to
// prevent cycles, because TaskDTO simply has no "project" field at all.
public record ProjectDTO(int id, String name, int taskCount, List<TaskDTO> tasks) {
}
