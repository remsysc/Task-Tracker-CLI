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
        LocalDateTime myObj = LocalDateTime.now();
        this.createdAt = myObj.toString();
        this.updatedAt = "Unknown";

    }

    public int getId() {
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdatedAt() {
        LocalDateTime myObj = LocalDateTime.now();
        this.updatedAt = myObj.toString();
    }

    public void displayInfo() {

        System.out.println("Id: " + id + "\nDescription: " + description + "\nStatus: " + status + "\nCreated At: " + createdAt + "\nUpdated At: " + updatedAt);

    }

}
