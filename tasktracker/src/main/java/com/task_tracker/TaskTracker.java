package com.task_tracker;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {

    private final List<Task> tasks;

    public TaskTracker() {

        tasks = new ArrayList<>();
    }

    // public static void writeJson() {
    //     StringBuilder jsonBuilder = new StringBuilder();
    //     jsonBuilder.append("[");
    //     for (int i = 0; i < items.size(); i++) {
    //         jsonBuilder.append("\"").append(items.get(i)).append("\"");
    //         if (i < items.size() - 1) {
    //             jsonBuilder.append(",");
    //         }
    //     }
    //     jsonBuilder.append("]");
    //     // Convert StringBuilder to String
    //     String jsonString = jsonBuilder.toString();
    //     String filePath = "/home/rem/Dev/vscode/roadmap-Projects/task/tasktracker/src/main/resources/db.json";
    //     // Write to the specified file
    //     try (FileWriter fileWriter = new FileWriter(filePath)) {
    //         fileWriter.write(jsonString);
    //         System.out.println("Wrote successfully to " + filePath + "!");
    //     } catch (IOException e) {
    //         System.err.println("Error writing to file: " + e.getMessage());
    //     }
    // }
    // public static void readJson() {
    //     String filePath = "/home/rem/Dev/vscode/roadmap-Projects/task/tasktracker/src/main/resources/db.json";
    //     try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    //         StringBuilder jsonBuilder = new StringBuilder();
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             jsonBuilder.append(line);
    //         }
    //         String json = jsonBuilder.toString();
    //         json = json.substring(1, json.length() - 1);
    //         String[] data = json.split(",");
    //         for (int i = 0; i < data.length; i++) {
    //             data[i] = data[i].trim().replaceAll("^\"|\"$", "");
    //         }
    //         java.util.Collections.addAll(items, data);
    //     } catch (IOException e) {
    //         System.err.println(e);
    //     }
    // }
    public void add(String taskDescription) {

        tasks.add(new Task(taskDescription));
        System.out.println("Task added successfully!");

    }

    void printList() {
        for (Task i : tasks) {
            i.displayInfo();
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

}
