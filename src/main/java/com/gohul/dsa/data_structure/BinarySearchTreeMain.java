package com.gohul.dsa.data_structure;

import java.util.Scanner;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Binary Search Tree Operations ===");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Node");
            System.out.println("2. Search Node");
            System.out.println("3. Delete Node");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Inorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int val = sc.nextInt();
                    bst.add(val);
                    System.out.println(val + " added to the tree.");
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    int searchVal = sc.nextInt();
                    boolean found = bst.search(searchVal);
                    if (found)
                        System.out.println(searchVal + " found in the tree.");
                    else
                        System.out.println(searchVal + " not found in the tree.");
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteVal = sc.nextInt();
                    try {
                        bst.delete(deleteVal);
                        System.out.println(deleteVal + " deleted from the tree.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Preorder Traversal: ");
                    bst.preOrder();
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Inorder Traversal: ");
                    bst.inOrder();
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder Traversal: ");
                    bst.postOrder();
                    System.out.println();
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }
}
