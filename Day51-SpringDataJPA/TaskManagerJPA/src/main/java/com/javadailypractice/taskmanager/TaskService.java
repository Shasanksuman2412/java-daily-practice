package com.javadailypractice.taskmanager;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) { // constructor injection, Day 49
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(int id) {
        return taskRepository.findById(id); // already returns Optional - Day 38!
    }

    public Task addTask(Task task) {
        return taskRepository.save(task); // save() handles BOTH insert and update
    }

    public Optional<Task> updateTask(int id, Task updatedTask) {
        Optional<Task> existing = taskRepository.findById(id);
        if (existing.isPresent()) {
            Task task = existing.get();
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return Optional.of(taskRepository.save(task)); // save() again = UPDATE this time
        }
        return Optional.empty();
    }

    public boolean deleteTask(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true); // uses our custom query method
    }
}
