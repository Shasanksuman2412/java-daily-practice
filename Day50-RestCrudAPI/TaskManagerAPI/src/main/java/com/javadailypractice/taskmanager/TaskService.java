package com.javadailypractice.taskmanager;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>(); // in-memory storage for today
    private int nextId = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> findById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst(); // Day 38's Optional, Day 19's streams
    }

    public Task addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public Optional<Task> updateTask(int id, Task updatedTask) {
        Optional<Task> existing = findById(id);
        if (existing.isPresent()) {
            Task task = existing.get();
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return Optional.of(task);
        }
        return Optional.empty();
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id); // Day 19's removeIf, returns true if something was removed
    }
}
