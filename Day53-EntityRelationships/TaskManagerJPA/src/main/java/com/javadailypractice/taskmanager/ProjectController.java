package com.javadailypractice.taskmanager;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable int id) {
        return projectService.findById(id);
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.addProject(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id); // cascades to delete this project's tasks too
        return ResponseEntity.noContent().build();
    }

    // ---- Nested resource: create a task UNDER a specific project ----
    @PostMapping("/{projectId}/tasks")
    public Task addTaskToProject(@PathVariable int projectId, @Valid @RequestBody Task task) {
        return projectService.addTaskToProject(projectId, task);
    }

    // ---- Nested resource: list all tasks belonging to a specific project ----
    @GetMapping("/{projectId}/tasks")
    public List<Task> getProjectTasks(@PathVariable int projectId) {
        return projectService.getTasksForProject(projectId);
    }
}
