package com.javadailypractice.taskmanager;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks().stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable int id) {
        return TaskMapper.toDTO(taskService.findById(id));
    }

    // ---- Takes a CreateTaskRequest (limited fields), returns a TaskDTO (limited fields) ----
    @PostMapping
    public TaskDTO createTask(@Valid @RequestBody CreateTaskRequest request) {
        Task task = TaskMapper.toEntity(request);
        return TaskMapper.toDTO(taskService.addTask(task));
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable int id, @Valid @RequestBody UpdateTaskRequest request) {
        Task updated = taskService.updateTask(id, request.title(), request.completed());
        return TaskMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/completed")
    public List<TaskDTO> getCompletedTasks() {
        return taskService.getCompletedTasks().stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }
}
