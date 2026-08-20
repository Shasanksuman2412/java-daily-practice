package com.javadailypractice.taskmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class SolutionsController {

    private final TaskService taskService;

    public SolutionsController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ---- Exercise 2: filter by completion status ----
    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return taskService.getAllTasks().stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    // ---- Exercise 3: count endpoint, returns a plain int ----
    @GetMapping("/count")
    public int countTasks() {
        return taskService.getAllTasks().size();
    }

    // ---- Exercise 4: PATCH - partial update, no full Task body needed ----
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> markComplete(@PathVariable int id) {
        Optional<Task> existing = taskService.findById(id);
        if (existing.isPresent()) {
            Task task = existing.get();
            task.setCompleted(true); // only this field changes, unlike PUT which replaces everything
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    // ---- Exercise 5: custom error handling for bad JSON input ----
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleBadJson(HttpMessageNotReadableException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid request body - please check your JSON format.");
    }
}
