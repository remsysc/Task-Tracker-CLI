package com.task_tracker;

public class Main {

    public static void main(String[] args) {

        TaskTracker.readJson();

        if (args.length < 2) {
            System.out.println("Please provide 2 arguments.");
            return;
        }

        String args1 = args[0];
        String args2 = args[1];

        System.out.println(args1);
        System.out.println(args2);

        switch (args1) {
            case "add" ->
                TaskTracker.add(args2);
            default ->
                System.out.println("Invalid.");
        }

        TaskTracker.printList();
        TaskTracker.writeJson();
    }
}
