package org.example;

import org.example.cli.TaskCLI;
import org.example.repository.TaskRepositoryList;
import org.example.service.TaskService;

public class Main {
    public static void main(String[] args) {

        new TaskCLI(new TaskService(new TaskRepositoryList())).run();

    }
}