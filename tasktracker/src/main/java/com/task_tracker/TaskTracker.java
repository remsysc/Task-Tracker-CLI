package com.task_tracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTracker {

    private final List<Task> tasks;

    public TaskTracker() {

        tasks = new ArrayList<>();
    }

    public void writeJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < tasks.size(); i++) {

            Task task = tasks.get(i);
            jsonBuilder.append("\n  {");
            jsonBuilder.append("\n    \"id\": ").append(task.getId()).append(",");
            jsonBuilder.append("\n    \"description\": \"").append(task.getDescription()).append("\",");
            jsonBuilder.append("\n    \"status\": \"").append(task.getStatus()).append("\",");
            jsonBuilder.append("\n    \"createdAt\": \"").append(task.getCreatedAt()).append("\",");
            jsonBuilder.append("\n    \"updatedAt\": \"").append(task.getUpdatedAt()).append("\"");
            jsonBuilder.append("\n  }");

            if (i < tasks.size() - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("\n]");
        // Convert StringBuilder to String
        String jsonString = jsonBuilder.toString();
        String filePath = "/home/rem/Dev/vscode/roadmap-Projects/task/tasktracker/src/main/resources/db.json";
        //  Write to the specified file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonString);
            fileWriter.flush();
            System.out.println("Wrote successfully to " + filePath + "!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readJson() {
        String filePath = "/home/rem/Dev/vscode/roadmap-Projects/task/tasktracker/src/main/resources/db.json";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line);
            }

            String json = jsonBuilder.toString();
            json = json.substring(1, json.length() - 1).trim();
            String[] taskStrings = json.split("\\},\\s*\\{");

            int maxId = 0;
            for (String taskString : taskStrings) {
                taskString = taskString.replace("{", "").replace("}", "").trim();
                String[] properties = taskString.split(",");
                int id = Integer.parseInt(properties[0].split(":")[1].trim());
                String description = properties[1].split(":")[1].trim().replaceAll("^\"|\"$", "");
                String status = properties[2].split(":")[1].trim().replaceAll("^\"|\"$", "");
                String createdAt = properties[3].split(":")[1].trim().replaceAll("^\"|\"$", "");
                String updatedAt = properties[4].split(":")[1].trim().replaceAll("^\"|\"$", "");

                Task task = new Task(id, description, status, createdAt, updatedAt);
                tasks.add(task);

                if (id > maxId) {
                    maxId = id;
                }
            }

            Task.setNextId(maxId + 1);
            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public void add(String taskDescription) {

        tasks.add(new Task(taskDescription));
        System.out.println("Task added successfully!");

    }

    void printList(String list) {

        if (null == list) {

            for (Task i : tasks) {
                i.displayInfo();
            }
        } else {
            switch (list) {
                case "done" -> {
                    for (Task i : tasks) {

                        if (i.getStatus().equals("Done")) {
                            i.displayInfo();
                        }
                    }
                }
                case "in-progress" -> {
                    for (Task i : tasks) {

                        if (i.getStatus().equals("In Progress")) {
                            i.displayInfo();
                        }
                    }
                }
                case "todo" -> {
                    for (Task i : tasks) {

                        if (i.getStatus().equals("ToDo")) {
                            i.displayInfo();
                        }
                    }
                }
                default -> {
                }
            }
        }
    }

    void update(int index, String updatedName) {

        for (Task i : tasks) {

            if (i.getId() == index) {
                i.setDescription(updatedName);
                i.setUpdatedAt();

                break;
            }
        }
    }

    void delete(int index) {

        for (Task i : tasks) {
            if (i.getId() == index) {

                i.displayInfo();
                System.out.println("Removed Successfully!");

                tasks.remove(tasks.indexOf(i));

                break;
            }
        }
    }

    void setInProgress(int index) {
        for (Task i : tasks) {
            if (i.getId() == index) {

                i.setStatus("In Progress");

                System.out.println("Successfully!");

                break;
            }
        }
    }

    void setDone(int index) {
        for (Task i : tasks) {
            if (i.getId() == index) {

                i.setStatus("Done");

                System.out.println("Successfully!");

                break;
            }
        }
    }

    void setTodo(int index) {
        for (Task i : tasks) {
            if (i.getId() == index) {

                i.setStatus("ToDo");

                System.out.println("Successfully!");

                break;
            }
        }
    }

}
