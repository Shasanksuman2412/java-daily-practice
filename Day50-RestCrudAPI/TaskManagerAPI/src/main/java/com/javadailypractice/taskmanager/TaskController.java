package com.javadailypractice.taskmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks") // shared prefix for ALL endpoints in this controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ---- GET /tasks - read all ----
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // ---- GET /tasks/{id} - read one, with proper 404 handling ----
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get()); // 200 OK
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

    // ---- POST /tasks - create ----
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
        Task created = taskService.addTask(task);
        return ResponseEntity.ok(created);
    }

    // ---- PUT /tasks/{id} - update ----
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
        Optional<Task> updated = taskService.updateTask(id, task);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        }
        return ResponseEntity.notFound().build();
    }

    // ---- DELETE /tasks/{id} - delete ----
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        boolean deleted = taskService.deleteTask(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build();
    }
}
