package com.gohul.dsa.data_structure;

import java.util.Scanner;

public class LinkedListMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        boolean running = true;

        System.out.println("=== Custom Linked List Operations ===");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at First");
            System.out.println("2. Insert at Last");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at First");
            System.out.println("5. Delete at Last");
            System.out.println("6. Delete at Position");
            System.out.println("7. Update at Position");
            System.out.println("8. Get Element by Position");
            System.out.println("9. Search Element");
            System.out.println("10. Check if Element Exists");
            System.out.println("11. Display All Elements");
            System.out.println("12. Get List Size");
            System.out.println("13. Reverse the list");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter element to insert at first: ");
                        String first = sc.nextLine();
                        list.insertAtFirst(first);
                        System.out.println("✅ Element inserted at first!");
                        break;

                    case "2":
                        System.out.print("Enter element to insert at last: ");
                        String last = sc.nextLine();
                        list.insertAtLast(last);
                        System.out.println("✅ Element inserted at last!");
                        break;

                    case "3":
                        System.out.print("Enter position: ");
                        int pos = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter element: ");
                        String value = sc.nextLine();
                        list.insertAtPos(pos, value);
                        System.out.println("✅ Element inserted at position " + pos + "!");
                        break;

                    case "4":
                        list.deleteAtFirst();
                        System.out.println("✅ First element deleted!");
                        break;

                    case "5":
                        list.deleteAtLast();
                        System.out.println("✅ Last element deleted!");
                        break;

                    case "6":
                        System.out.print("Enter position to delete: ");
                        int delPos = Integer.parseInt(sc.nextLine());
                        list.deleteAtPos(delPos);
                        System.out.println("✅ Element deleted at position " + delPos + "!");
                        break;

                    case "7":
                        System.out.print("Enter position to update: ");
                        int updatePos = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter new value: ");
                        String newVal = sc.nextLine();
                        list.updateAtPos(updatePos, newVal);
                        System.out.println("✅ Element updated at position " + updatePos + "!");
                        break;

                    case "8":
                        System.out.print("Enter position to get element: ");
                        int getPos = Integer.parseInt(sc.nextLine());
                        System.out.println("📍 Element at position " + getPos + " is: " + list.get(getPos));
                        break;

                    case "9":
                        System.out.print("Enter element to search: ");
                        String searchVal = sc.nextLine();
                        int foundPos = list.search(searchVal);
                        if (foundPos != -1)
                            System.out.println("🔍 Element found at position: " + foundPos);
                        else
                            System.out.println("❌ Element not found!");
                        break;

                    case "10":
                        System.out.print("Enter element to check: ");
                        String checkVal = sc.nextLine();
                        System.out.println(list.contains(checkVal)
                                ? "✅ Element exists in the list!"
                                : "❌ Element not found in the list!");
                        break;

                    case "11":
                        System.out.println("\n📜 Elements in the Linked List:");
                        for (String item : list) {
                            System.out.print(item + " -> ");
                        }
                        System.out.println("null");
                        break;

                    case "12":
                        System.out.println("📏 Size of the Linked List: " + list.getSize());
                        break;

                    case "13":
                        list.reverse();
                        System.out.println("List elements got reversed");
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
