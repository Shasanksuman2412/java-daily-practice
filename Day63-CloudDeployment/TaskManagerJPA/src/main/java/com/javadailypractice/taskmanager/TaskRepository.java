package com.javadailypractice.taskmanager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    // Non-paginated version, kept for the /tasks/completed endpoint from
    // earlier days that doesn't need paging yet.
    List<Task> findByCompleted(boolean completed);

    // New today: a PAGINATED version of the same query - Spring generates
    // the SQL from the method name, same as always, but now also honors
    // page/size/sort automatically because of the Pageable parameter.
    Page<Task> findByCompleted(boolean completed, Pageable pageable);

    // findAll(Pageable pageable) is ALREADY inherited from JpaRepository -
    // no code needed here at all for the main paginated listing.
}
