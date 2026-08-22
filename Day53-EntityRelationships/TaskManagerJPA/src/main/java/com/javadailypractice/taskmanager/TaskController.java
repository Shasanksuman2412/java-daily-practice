package com.javadailypractice.taskmanager;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.findById(id);
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @Valid @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return taskService.getCompletedTasks();
    }
}
