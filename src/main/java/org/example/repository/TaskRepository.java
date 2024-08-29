package org.example.repository;

import org.example.model.Task;

import java.util.List;

public interface TaskRepository {
    Task createTask(Task task);
    List<Task> listTasks();
}
