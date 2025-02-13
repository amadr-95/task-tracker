package org.example.cli;

import org.example.exception.TaskException;
import org.example.exception.TaskFieldException;
import org.example.model.Task;
import org.example.service.TaskService;

import java.util.Scanner;
import java.util.UUID;

public class TaskCLI {

    private final TaskService taskService;
    private final Scanner scanner = new Scanner(System.in);

    public TaskCLI(TaskService taskService) {
        this.taskService = taskService;
    }

    public void run() {
        printBanner();
        String command;
        do {
            command = scanner.next();
            switch (command) {
                case "add" -> createTask();
                case "list" -> listTasks();
                case "delete" -> deleteTask();
                case "exit" -> System.out.println("Bye 👋🏼");
                default -> {
                    System.out.println("Command not recognised. Try again");
                    printHelp();
                }
            }
        } while (!command.equalsIgnoreCase("exit"));
    }

    private void printHelp() {
        String help = """
                - add [description] : Add a new task
                - delete [id] : Delete a task
                - update [id] [description] : Update a task
                - mark-todo [id] : Mark a task as Todo
                - mark-in-progress [id] : Mark a task as In-Progress
                - mark-done [id] : Mark a task as Done
                - list : List all tasks
                - list-todo : List all Todo tasks
                - list-in-progress : List all In-Progress tasks
                - list-done : List all Done tasks
                - exit : Exit the program
                """;
        System.out.println(help);
        scanner.nextLine(); //clear scanner
    }

    private void listTasks() {
        for (Task task : taskService.listTasks()) {
            System.out.println(task);
        }
    }

    private void createTask() {
        String description = scanner.nextLine().substring(1);
        try {
            UUID taskID = taskService.createTask(description).getUuid();
            System.out.printf("Task added successfully (ID: %s)%n", taskID);
        } catch (TaskFieldException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteTask() {
        String uuid = scanner.next();
        try {
            taskService.deleteTask(uuid);
            System.out.printf("Task deleted successfully (ID: %s)%n", uuid);
        } catch (TaskException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printBanner() {
        System.out.println("""
                *************************************
                *         CLI TASK TRACKER          *
                *************************************
                
                Add, edit, list, and remove your notes
                """);
    }
}
