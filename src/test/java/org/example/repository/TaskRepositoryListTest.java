package org.example.repository;

import org.example.exception.TaskNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryListTest {

    private TaskRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new TaskRepositoryList();
    }

    @Test
    void it_should_throw_exception_when_uuid_is_not_found() {
        //Given
        UUID taskId = UUID.randomUUID();

        // When / Then
        String message = assertThrows(TaskNotFoundException.class,
                () -> underTest.deleteTask(taskId)).getMessage();

        assertEquals(message, String.format("Task ID %s does not exist. Try again.", taskId));
    }
}