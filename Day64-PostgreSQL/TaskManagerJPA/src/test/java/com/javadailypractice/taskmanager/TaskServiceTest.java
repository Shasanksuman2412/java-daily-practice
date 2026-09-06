package com.javadailypractice.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // enables @Mock/@InjectMocks WITHOUT starting Spring at all - fast
class TaskServiceTest {

    @Mock // a completely FAKE TaskRepository - we control exactly what it returns
    private TaskRepository taskRepository;

    @InjectMocks // Spring-free: Mockito creates a real TaskService, injecting the mock repository
    private TaskService taskService;

    private Task sampleTask;

    @BeforeEach
    void setUp() {
        sampleTask = new Task("Sample task", false);
        sampleTask.setId(1);
    }

    @Test
    void findByIdReturnsTaskWhenPresent() {
        when(taskRepository.findById(1)).thenReturn(Optional.of(sampleTask));

        Task result = taskService.findById(1);

        assertEquals("Sample task", result.getTitle());
        verify(taskRepository).findById(1); // confirms the mock was actually called
    }

    @Test
    void findByIdThrowsWhenTaskMissing() {
        when(taskRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () -> taskService.findById(99));
    }

    @Test
    void addTaskSavesAndReturnsTheTask() {
        when(taskRepository.save(sampleTask)).thenReturn(sampleTask);

        Task result = taskService.addTask(sampleTask);

        assertEquals(sampleTask, result);
        verify(taskRepository, times(1)).save(sampleTask); // called EXACTLY once
    }

    @Test
    void updateTaskChangesTitleAndCompletedStatus() {
        when(taskRepository.findById(1)).thenReturn(Optional.of(sampleTask));
        when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task updated = taskService.updateTask(1, "Updated title", true);

        assertEquals("Updated title", updated.getTitle());
        assertTrue(updated.isCompleted());
    }

    @Test
    void deleteTaskThrowsWhenTaskDoesNotExist() {
        when(taskRepository.existsById(99)).thenReturn(false);

        assertThrows(TaskNotFoundException.class, () -> taskService.deleteTask(99));
        verify(taskRepository, never()).deleteById(anyInt()); // deleteById should NEVER be called in this case
    }

    @Test
    void getCompletedTasksDelegatesToRepository() {
        when(taskRepository.findByCompleted(true)).thenReturn(List.of(sampleTask));

        List<Task> result = taskService.getCompletedTasks();

        assertEquals(1, result.size());
    }
}
