package org.example.service;

import org.example.exception.TaskNotFoundException;
import org.example.model.Task;
import org.example.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

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
    
    public void deleteTask(String taskId) throws TaskNotFoundException {
        UUID uuid;
        try {
            uuid = UUID.fromString(taskId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        taskRepository.deleteTask(uuid);
    }

}
