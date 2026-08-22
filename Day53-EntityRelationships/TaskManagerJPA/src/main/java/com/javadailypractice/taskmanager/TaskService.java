package com.javadailypractice.taskmanager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task findById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(int id, Task updatedTask) {
        Task task = findById(id);
        task.setTitle(updatedTask.getTitle());
        task.setCompleted(updatedTask.isCompleted());
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
}
