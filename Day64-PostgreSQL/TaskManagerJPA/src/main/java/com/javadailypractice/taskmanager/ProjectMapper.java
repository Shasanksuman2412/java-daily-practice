package com.javadailypractice.taskmanager;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDTO toDTO(Project project) {
        List<TaskDTO> taskDTOs = project.getTasks().stream()
                .map(TaskMapper::toDTO) // Day 19's streams + method references
                .collect(Collectors.toList());
        return new ProjectDTO(project.getId(), project.getName(), taskDTOs.size(), taskDTOs);
    }

    public static Project toEntity(CreateProjectRequest request) {
        return new Project(request.name());
    }
}
