package com.javadailypractice.taskmanager;

import java.util.List;

public record ProjectDTO(int id, String name, int taskCount, List<TaskDTO> tasks) {
}
