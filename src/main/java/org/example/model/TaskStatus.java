package org.example.model;

public enum TaskStatus {

    TODO("to do"),
    IN_PROGRESS("in progress"),
    DONE("done");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

