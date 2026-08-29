package com.javadailypractice.taskmanager;

public class TaskMapper {

    public static TaskDTO toDTO(Task task) {
        int projectId = task.getProject() != null ? task.getProject().getId() : 0;
        return new TaskDTO(task.getId(), task.getTitle(), task.isCompleted(), projectId);
    }

    public static Task toEntity(CreateTaskRequest request) {
        return new Task(request.title(), false); // new tasks always start incomplete
    }
}
