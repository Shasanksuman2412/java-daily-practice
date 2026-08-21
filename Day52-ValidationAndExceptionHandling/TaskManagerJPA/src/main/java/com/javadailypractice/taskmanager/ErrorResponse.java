package com.javadailypractice.taskmanager;

// A record (Day 35) - immutable, minimal boilerplate, perfect for a
// simple response shape sent back as JSON on every error.
public record ErrorResponse(int status, String message) {
}
