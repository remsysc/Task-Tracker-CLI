package com.task_tracker;

import java.time.LocalDateTime;

public class Task {

    //id should be the index;
    public static int nextId = 1;
    private final int id;
    private String description;
    private String status;
    private final String createdAt;
    private String updatedAt;

    Task(String description) {
        this.id = nextId++;
        this.description = description;
        this.status = "Unknown";
        this.createdAt = LocalDateTime.now().toString();
        this.updatedAt = "Unknown";

    }

    Task(int id, String description, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    public int getId() {
        return this.id;
    }

    public static void setNextId(int nextId) {
        Task.nextId = nextId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCreatedAt() {

        return this.createdAt;
    }

    public String getUpdatedAt() {

        return this.updatedAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now().toString();
    }

    public void displayInfo() {

        System.out.println("Id: " + id + "\nDescription: " + description + "\nStatus: " + status + "\nCreated At: " + createdAt + "\nUpdated At: " + updatedAt);

    }

}
