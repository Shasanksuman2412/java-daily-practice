package com.javadailypractice.taskmanager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // ---- Kept for anything that still wants everything at once (internal use, etc.) ----
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ---- New today: paginated listing ----
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable); // inherited from JpaRepository, no extra code needed
    }

    public Task findById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(int id, String title, boolean completed) {
        Task task = findById(id);
        task.setTitle(title);
        task.setCompleted(completed);
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    // ---- New today: paginated version of the completed-tasks query ----
    public Page<Task> getCompletedTasks(Pageable pageable) {
        return taskRepository.findByCompleted(true, pageable);
    }
}
