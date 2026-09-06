package com.javadailypractice.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// @DataJpaTest loads ONLY the JPA-related parts of the application (not
// the full app, not security, not controllers) - fast, but genuinely
// exercises real SQL against an in-memory database, unlike TaskServiceTest.
@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void savedTaskCanBeFoundById() {
        Task task = taskRepository.save(new Task("Learn Spring testing", false));

        Optional<Task> found = taskRepository.findById(task.getId());

        assertTrue(found.isPresent());
        assertEquals("Learn Spring testing", found.get().getTitle());
    }

    @Test
    void findByCompletedReturnsOnlyMatchingTasks() {
        taskRepository.save(new Task("Done task", true));
        taskRepository.save(new Task("Not done task 1", false));
        taskRepository.save(new Task("Not done task 2", false));

        List<Task> completedTasks = taskRepository.findByCompleted(true);
        List<Task> incompleteTasks = taskRepository.findByCompleted(false);

        assertEquals(1, completedTasks.size());
        assertEquals(2, incompleteTasks.size());
    }

    @Test
    void deletingATaskActuallyRemovesItFromTheDatabase() {
        Task task = taskRepository.save(new Task("Temporary task", false));
        int id = task.getId();

        taskRepository.deleteById(id);

        assertFalse(taskRepository.existsById(id));
    }

    @Test
    void findAllReturnsEveryTask() {
        taskRepository.save(new Task("Task A", false));
        taskRepository.save(new Task("Task B", true));

        List<Task> all = taskRepository.findAll();

        assertEquals(2, all.size());
    }
}
