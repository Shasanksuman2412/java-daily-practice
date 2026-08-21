package com.javadailypractice.taskmanager;

// A RuntimeException (unchecked, Day 15) since Spring controllers don't
// want to be forced to declare "throws" everywhere - the GlobalExceptionHandler
// catches this centrally instead.
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(int id) {
        super("Task not found with id: " + id);
    }
}
