package com.javadailypractice.taskmanager;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    // ---- Main listing: now paginated and sortable ----
    // Spring automatically parses ?page=0&size=10&sort=title,asc from the
    // query string into this Pageable - no manual parsing needed at all.
    @GetMapping
    public PageResponse<TaskDTO> getAllTasks(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
        Page<Task> taskPage = taskService.getAllTasks(pageable);
        Page<TaskDTO> dtoPage = taskPage.map(TaskMapper::toDTO); // Page's own .map(), same idea as Day 19's streams
        return PageResponse.from(dtoPage);
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable int id) {
        return TaskMapper.toDTO(taskService.findById(id));
    }

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

    // ---- Kept simple/unpaginated for callers that just want the full list ----
    @GetMapping("/completed")
    public List<TaskDTO> getCompletedTasks() {
        return taskService.getCompletedTasks().stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ---- New today: a paginated version of the same query ----
    @GetMapping("/completed/paged")
    public PageResponse<TaskDTO> getCompletedTasksPaged(@PageableDefault(size = 10) Pageable pageable) {
        Page<Task> taskPage = taskService.getCompletedTasks(pageable);
        return PageResponse.from(taskPage.map(TaskMapper::toDTO));
    }
}
