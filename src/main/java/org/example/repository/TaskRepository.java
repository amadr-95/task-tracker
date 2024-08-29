package org.example.repository;

import org.example.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
    Task createTask(Task task);
    List<Task> listTasks();
    void deleteTask(Task task);
}
