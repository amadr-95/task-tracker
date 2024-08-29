package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String description) {
        // check description
        if(description == null || description.isBlank())
            throw new IllegalArgumentException("Description can not be empty");

        Task task = new Task(description);
        return taskRepository.createTask(task);
    }

    public List<Task> listTasks() {
        return taskRepository.listTasks();
    }
}
