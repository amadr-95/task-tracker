package org.example.service;

import org.example.exception.TaskException;
import org.example.exception.TaskFieldException;
import org.example.model.Task;
import org.example.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String description) throws TaskFieldException {
        // check description
        if(description == null || description.isBlank())
            throw new TaskFieldException("Description can not be empty");

        Task task = new Task(description);
        return taskRepository.createTask(task);
    }

    public List<Task> listTasks() {
        return taskRepository.listTasks();
    }
    
    public void deleteTask(String taskId) throws TaskException {
        UUID uuid;
        try {
            uuid = UUID.fromString(taskId);
        } catch (IllegalArgumentException e) {
            throw new TaskFieldException("UUID has not have valid format. Try again.");
        }
        taskRepository.deleteTask(uuid);
    }

}
