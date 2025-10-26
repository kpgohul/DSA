package com.gohul.dsa.data_structure;

import java.util.Scanner;

public class QueueMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>();
        boolean running = true;

        System.out.println("=== Custom Queue Implementation ===");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. View Front Element");
            System.out.println("4. View Rear Element");
            System.out.println("5. Check if Element Exists");
            System.out.println("6. Display Queue Elements");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    System.out.println(value + " added to the queue.");
                    break;

                case 2:
                    try {
                        int removed = queue.dequeue();
                        System.out.println("Dequeued element: " + removed);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    Integer front = queue.getFront();
                    if (front != null)
                        System.out.println("Front element: " + front);
                    else
                        System.out.println("Queue is empty.");
                    break;

                case 4:
                    Integer rear = queue.getRear();
                    if (rear != null)
                        System.out.println("Rear element: " + rear);
                    else
                        System.out.println("Queue is empty.");
                    break;

                case 5:
                    System.out.print("Enter value to check: ");
                    int data = sc.nextInt();
                    System.out.println(queue.contains(data)
                            ? "Element found ✅"
                            : "Element not found ❌");
                    break;

                case 6:
                    System.out.println("Queue elements (front → rear):");
                    for (int item : queue) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting... 👋");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
