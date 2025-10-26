package com.gohul.dsa.data_structure;

import java.util.Scanner;

public class DynamicArrayMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DynamicArray<String> array = new DynamicArray<>();
        boolean running = true;

        System.out.println("=== Dynamic Array Operations ===");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Element");
            System.out.println("2. Insert Element at Index");
            System.out.println("3. Update Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Display Elements");
            System.out.println("6. Get Length");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter element to add: ");
                        String elementToAdd = sc.nextLine();
                        array.add(elementToAdd);
                        System.out.println("✅ Element added successfully!");
                        break;

                    case "2":
                        System.out.print("Enter index: ");
                        int insertIndex = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter element to insert: ");
                        String insertElement = sc.nextLine();
                        array.insert(insertIndex, insertElement);
                        System.out.println("✅ Element inserted successfully!");
                        break;

                    case "3":
                        System.out.print("Enter index to update: ");
                        int updateIndex = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter new element: ");
                        String newElement = sc.nextLine();
                        array.update(updateIndex, newElement);
                        System.out.println("✅ Element updated successfully!");
                        break;

                    case "4":
                        System.out.print("Enter index to delete: ");
                        int deleteIndex = Integer.parseInt(sc.nextLine());
                        array.delete(deleteIndex);
                        System.out.println("✅ Element deleted successfully!");
                        break;

                    case "5":
                        System.out.println("\nCurrent elements in Dynamic Array:");
                        for (String item : array) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                        break;

                    case "6":
                        System.out.println("\n Length of the Array: "+array.length());
                        break;

                    case "0":
                    case "q":
                    case "Q":
                        running = false;
                        System.out.println("👋 Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("⚠️ Invalid choice! Please try again.");
                }

            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
