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
    
    public void deleteTask(UUID taskId) {
        Task task = findTaskById(taskId);
        taskRepository.deleteTask(task);
    }

    private Task findTaskById(UUID taskId) {
        return taskRepository.listTasks().stream()
                .filter(task -> task.getUuid().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(
                        String.format("Task ID %s does not exist", taskId)));

    }
}
