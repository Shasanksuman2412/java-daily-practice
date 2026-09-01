package com.javadailypractice.taskmanager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project findById(int id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(int id) {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException(id);
        }
        projectRepository.deleteById(id);
    }

    public Task addTaskToProject(int projectId, Task task) {
        Project project = findById(projectId);
        task.setProject(project);
        return taskRepository.save(task);
    }
}
