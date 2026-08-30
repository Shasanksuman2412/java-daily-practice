package com.javadailypractice.taskmanager;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Tasks", description = "Endpoints for creating, reading, updating, and deleting tasks")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "List all tasks", description = "Returns a paginated, sortable list of tasks. " +
            "Requires authentication. Supports ?page, ?size, and ?sort query parameters.")
    @ApiResponse(responseCode = "200", description = "Page of tasks returned successfully")
    @GetMapping
    public PageResponse<TaskDTO> getAllTasks(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
        Page<Task> taskPage = taskService.getAllTasks(pageable);
        Page<TaskDTO> dtoPage = taskPage.map(TaskMapper::toDTO);
        return PageResponse.from(dtoPage);
    }

    @Operation(summary = "Get a task by ID", description = "Returns a single task, or a 404 error if it doesn't exist")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task found"),
            @ApiResponse(responseCode = "404", description = "No task exists with the given ID")
    })
    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable int id) {
        return TaskMapper.toDTO(taskService.findById(id));
    }

    @Operation(summary = "Create a new task", description = "Requires the ADMIN role. Title is required.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed (e.g. blank title)"),
            @ApiResponse(responseCode = "403", description = "Authenticated, but not an ADMIN")
    })
    @PostMapping
    public TaskDTO createTask(@Valid @RequestBody CreateTaskRequest request) {
        Task task = TaskMapper.toEntity(request);
        return TaskMapper.toDTO(taskService.addTask(task));
    }

    @Operation(summary = "Update an existing task", description = "Requires the ADMIN role. Replaces title and completed status.")
    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable int id, @Valid @RequestBody UpdateTaskRequest request) {
        Task updated = taskService.updateTask(id, request.title(), request.completed());
        return TaskMapper.toDTO(updated);
    }

    @Operation(summary = "Delete a task", description = "Requires the ADMIN role. Returns 204 on success.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "No task exists with the given ID")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "List all completed tasks (unpaginated)")
    @GetMapping("/completed")
    public List<TaskDTO> getCompletedTasks() {
        return taskService.getCompletedTasks().stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "List completed tasks, paginated")
    @GetMapping("/completed/paged")
    public PageResponse<TaskDTO> getCompletedTasksPaged(@PageableDefault(size = 10) Pageable pageable) {
        Page<Task> taskPage = taskService.getCompletedTasks(pageable);
        return PageResponse.from(taskPage.map(TaskMapper::toDTO));
    }
}
