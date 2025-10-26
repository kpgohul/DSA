package com.gohul.dsa.data_structure;

import java.util.Scanner;

public class DoublyCircularLinkedListMain {

    public static void main(String[] args) {
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Doubly Circular Linked List ===");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at first");
            System.out.println("2. Insert at last");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at first");
            System.out.println("5. Delete at last");
            System.out.println("6. Delete at position");
            System.out.println("7. Update at position");
            System.out.println("8. Forward traversal");
            System.out.println("9. Reverse traversal");
            System.out.println("10. Search element");
            System.out.println("11. Display size");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            int pos, value;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter value to insert at first: ");
                        value = sc.nextInt();
                        list.insertAtFirst(value);
                        System.out.println("Value " + value + " inserted at first successfully!");
                        break;
                    case 2:
                        System.out.print("Enter value to insert at last: ");
                        value = sc.nextInt();
                        list.insertAtLast(value);
                        System.out.println("Value " + value + " inserted at last successfully!");
                        break;
                    case 3:
                        System.out.print("Enter position to insert: ");
                        pos = sc.nextInt();
                        System.out.print("Enter value: ");
                        value = sc.nextInt();
                        list.insertAtPos(pos, value);
                        System.out.println("Value " + value + " inserted at position " + pos + " successfully!");
                        break;
                    case 4:
                        list.deleteAtFirst();
                        System.out.println("First element deleted successfully!");
                        break;
                    case 5:
                        list.deleteAtLast();
                        System.out.println("Last element deleted successfully!");
                        break;
                    case 6:
                        System.out.print("Enter position to delete: ");
                        pos = sc.nextInt();
                        list.deleteAtPos(pos);
                        System.out.println("Element at position " + pos + " deleted successfully!");
                        break;
                    case 7:
                        System.out.print("Enter position to update: ");
                        pos = sc.nextInt();
                        System.out.print("Enter new value: ");
                        value = sc.nextInt();
                        list.updateAtPos(pos, value);
                        System.out.println("Position " + pos + " updated successfully with value " + value + "!");
                        break;
                    case 8:
                        System.out.print("Forward traversal: ");
                        list.forwardTraverse();
                        break;
                    case 9:
                        System.out.print("Reverse traversal: ");
                        list.reverseTraversal();
                        break;
                    case 10:
                        System.out.print("Enter value to search: ");
                        value = sc.nextInt();
                        int index = list.search(value);
                        if (index == -1) System.out.println("Element not found.");
                        else System.out.println("Element found at position: " + index);
                        break;
                    case 11:
                        System.out.println("Size of list: " + list.getSize());
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
