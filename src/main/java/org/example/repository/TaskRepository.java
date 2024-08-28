package org.example.repository;

import org.example.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
    UUID createTask(Task task);
    List<Task> listTasks();
}
