package com.task_tracker;

public class Main {

    public static void main(String[] args) {

        TaskTracker task = new TaskTracker();
        task.readJson();

        if (args.length < 1) {
            System.out.println("Please provide atleast 1 arguments.");
            return;
        }

        switch (args[0]) {
            case "add" -> {
                if (args.length > 1) {
                    task.add(args[1]);
                } else {
                    return;
                }
            }
            case "update" -> {
                if (args.length < 3) {
                    System.out.println("Please provide 3 arguments.");
                    return;
                }
                int index = Integer.parseInt(args[1]);
                task.update(index, args[2]);
            }
            case "delete" -> {
                if (args.length > 1) {
                    task.delete(Integer.parseInt(args[1]));
                } else {
                    return;
                }

            }
            case "mark-in-progress" -> {
                if (args.length > 1) {
                    task.setInProgress(Integer.parseInt(args[1]));
                } else {
                    return;
                }

            }

            case "mark-done" -> {
                if (args.length > 1) {
                    task.setDone(Integer.parseInt(args[1]));
                } else {
                    return;
                }
                task.setDone(Integer.parseInt(args[1]));
            }
            case "mark-todo" -> {
                if (args.length > 1) {
                    task.setTodo(Integer.parseInt(args[1]));
                } else {
                    return;
                }
            }
            case "list" -> {
                if (args.length < 2) {
                    task.printList(null);
                } else {
                    task.printList(args[1]);
                }

            }  //to do add mark in progess and lists
            default ->
                System.out.println("Invalid command.");
        }

        // task.delete(1);
        task.writeJson();

    }
}
