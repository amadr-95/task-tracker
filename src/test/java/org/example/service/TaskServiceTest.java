package org.example.service;

import org.example.exception.TaskException;
import org.example.exception.TaskFieldException;
import org.example.model.Task;
import org.example.repository.TaskRepositoryList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.example.model.TaskStatus.TODO;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TaskService(new TaskRepositoryList());
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void it_should_create_task() throws TaskFieldException {
        //given a valid task description
        String description = "finish project";

        //When
        Task task = underTest.createTask(description);

        //Then
        assertNotNull(task.getUuid());
        assertEquals(task.getCreatedAt(), LocalDate.now());
        assertNull(task.getUpdatedAt());
        assertEquals(task.getDescription(), description);
        assertEquals(task.getStatus(), TODO);
    }

    @Test
    void it_should_throw_exception_when_description_is_null() {
        // When / Then
        assertThrows(TaskFieldException.class, () -> underTest.createTask(null));
    }

    @Test
    void it_should_throw_exception_when_description_is_empty() {
        //Given a not valid description
        String description = "";
        //When / Then
        String exceptionMessage = assertThrows(TaskFieldException.class,
                () -> underTest.createTask(description))
                .getMessage();
        assertEquals(exceptionMessage, "Description can not be empty");
    }

    @Test
    void it_should_return_a_list_of_tasks() throws TaskFieldException {
        //Given
        String description = "finish project";
        underTest.createTask(description);

        //When
        List<Task> tasks = underTest.listTasks();

        //Then
        assertEquals(tasks.size(), 1);
    }

    @Test
    void it_should_delete_task() throws TaskException {
        //Given a valid UUID (create task)
        String taskId = underTest.createTask("test").getUuid().toString();

        //When
        underTest.deleteTask(taskId);

        //Then
        assertEquals(underTest.listTasks().size(), 0);
    }

    @Test
    void it_should_throw_exception_when_uuid_is_not_valid() {
        //Given a valid UUID (create task)
        String taskId = "not valid UUID";

        // When / Then
        String message = assertThrows(TaskFieldException.class,
                () -> underTest.deleteTask(taskId)).getMessage();
        assertEquals(message, "UUID has not have valid format. Try again.");
    }

}