package org.example.repository;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepositoryList implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public UUID createTask(Task task) {
        tasks.add(task);
        return task.getUuid();
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
