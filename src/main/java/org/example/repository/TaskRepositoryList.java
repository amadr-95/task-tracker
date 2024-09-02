package org.example.repository;

import org.example.exception.TaskNotFoundException;
import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public void deleteTask(UUID taskId) throws TaskNotFoundException {
        tasks.remove(findTaskById(taskId));
    }

    private Task findTaskById(UUID taskId) throws TaskNotFoundException {
        return tasks.stream()
                .filter(task -> task.getUuid().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(
                        String.format("Task ID %s does not exist. Try again.", taskId)));

    }
}
