package org.example.repository;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryList implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
