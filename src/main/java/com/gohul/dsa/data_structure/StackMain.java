package com.gohul.dsa.data_structure;

import java.util.Scanner;

public class StackMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        boolean running = true;

        System.out.println("=== Custom Stack Implementation ===");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Element Exists");
            System.out.println("5. Display Stack Elements");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    System.out.println(value + " pushed onto stack.");
                    break;

                case 2:
                    try {
                        int popped = stack.pop();
                        System.out.println("Popped: " + popped);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Top element: " + stack.peek());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter value to check: ");
                    int data = sc.nextInt();
                    System.out.println(stack.consist(data)
                            ? "Element found ✅"
                            : "Element not found ❌");
                    break;

                case 5:
                    System.out.println("Stack elements (top → bottom):");
                    for (int item : stack) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                    break;

                case 6:
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
