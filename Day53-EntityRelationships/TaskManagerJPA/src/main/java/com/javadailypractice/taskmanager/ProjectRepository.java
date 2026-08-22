package com.javadailypractice.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // no custom queries needed yet - inherited CRUD methods are enough for today
}
