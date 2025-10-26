package com.gohul.algorithm.linked_list;


public class CycleDetection {

    private static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data =data;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        // Link nodes (10 -> 20 -> 30 -> 40 -> 50)
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Uncomment the below line to create a cycle (50 -> 30)
         fifth.next = third; // creates cycle

        // Check if cycle exists
        System.out.println(findCycle(head)
                ? "Cycle detected ✅"
                : "No cycle detected ❌");
    }


    public static boolean findCycle(Node head){
        Node speed = head;
        Node slow = head;

        while(speed != null && speed.next != null){

            slow = slow.next;
            speed = speed.next.next;

            if(speed == slow) return true;
        }
        return false;
    }

}
