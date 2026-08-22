package com.javadailypractice.taskmanager;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects().stream()
                .map(ProjectMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProjectDTO getProject(@PathVariable int id) {
        return ProjectMapper.toDTO(projectService.findById(id));
    }

    @PostMapping
    public ProjectDTO createProject(@Valid @RequestBody CreateProjectRequest request) {
        Project project = ProjectMapper.toEntity(request);
        return ProjectMapper.toDTO(projectService.addProject(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{projectId}/tasks")
    public TaskDTO addTaskToProject(@PathVariable int projectId, @Valid @RequestBody CreateTaskRequest request) {
        Task task = TaskMapper.toEntity(request);
        return TaskMapper.toDTO(projectService.addTaskToProject(projectId, task));
    }

    @GetMapping("/{projectId}/tasks")
    public List<TaskDTO> getProjectTasks(@PathVariable int projectId) {
        return ProjectMapper.toDTO(projectService.findById(projectId)).tasks();
    }
}
