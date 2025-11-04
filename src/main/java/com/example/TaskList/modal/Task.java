package com.example.TaskList.modal;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 5, message = "Title should be atleat of 5 characters")
    private String title;
    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, max = 50, message = "description should be atleat of 10 characters")
    private String description;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dueDate;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Task(Long id, String title, String description, Date dueDate, TaskStatus status, LocalDateTime created_at, LocalDateTime updated_at) {
        Id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task() {
    }
}
