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
        projectRepository.deleteById(id); // cascade = CascadeType.ALL means its Tasks get deleted too
    }

    // ---- Attaches a new Task to an existing Project ----
    public Task addTaskToProject(int projectId, Task task) {
        Project project = findById(projectId); // throws ProjectNotFoundException if missing
        task.setProject(project);
        return taskRepository.save(task);
    }

    public List<Task> getTasksForProject(int projectId) {
        Project project = findById(projectId);
        return project.getTasks();
    }
}
