package com.javadailypractice.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Extending JpaRepository<Task, Integer> (entity type, ID type) instantly
// provides save(), findById(), findAll(), deleteById(), count(), and more -
// NO implementation needed, Spring generates it at runtime.
public interface TaskRepository extends JpaRepository<Task, Integer> {

    // Custom query, generated automatically from the METHOD NAME alone -
    // Spring parses "findByCompleted" and builds the SQL for us.
    List<Task> findByCompleted(boolean completed);
}
