package org.example.model;
import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private UUID uuid;
    private String description;
    private TaskStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Task(String description) {
        this.uuid = UUID.randomUUID();
        this.status = TaskStatus.TODO; // by default
        this.description = description;
        this.createdAt = LocalDate.now();
        this.updatedAt = null;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "uuid=" + uuid +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

