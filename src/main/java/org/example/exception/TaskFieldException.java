package org.example.exception;

public class TaskFieldException extends TaskException {
    public TaskFieldException() {
        super();
    }

    public TaskFieldException(String message) {
        super(message);
    }

    public TaskFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskFieldException(Throwable cause) {
        super(cause);
    }

    protected TaskFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
