package com.gohul.dsa.data_structure;

import java.util.Iterator;

/**
 * @param index position starting from 1
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    private class Node{
        T data;
        Node next;
        Node prev;

        public Node(T data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtFirst(T data){
        Node newNode = new Node(data);

        if(head == null){
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void insertAtLast(T data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }


        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

        size++;
    }

    public void deleteAtFirst(){
        if(head == null) throw new IndexOutOfBoundsException("List is empty");
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteAtLast() {
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }


    public void insertAtPos(int index, T data) {

        if (index <= 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be >= 1.");

        if (index > size + 1)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Exceeds list size.");

        if (index == 1) {
            insertAtFirst(data);
            return;
        }
        if (index == size + 1) {
            insertAtLast(data);
            return;
        }

        Node temp = head;
        Node newNode = new Node(data);

        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }


    public void deleteAtPos(int index) {
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty.");

        if (index <= 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be >= 1.");

        if (index == 1) {
            deleteAtFirst();
            return;
        }

        if (index == size) {
            deleteAtLast();
            return;
        }

        Node current = head;
        Node previous = null;

        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.next;

            if (current == null)
                throw new IndexOutOfBoundsException("Invalid index: " + index + ". No such position in the list.");
        }

        previous.next = current.next;
        current.next.prev = previous;
        size--;
    }

    public void updateAtPos(int index, T data){

        if (head == null)
            throw new IndexOutOfBoundsException("List is empty.");

        if (index <= 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be >= 1.");

        if (index > size)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Exceeds list size.");

        Node temp = head;

        for(int i=1; i<index; i++){
            temp = temp.next;

            if(temp == null){
                throw new IndexOutOfBoundsException("Invalid index: " + index + ". No such position in the list.");
            }
        }

        temp.data = data;

    }

    public T get(int index){

        if (head == null)
            throw new IndexOutOfBoundsException("List is empty.");

        if (index <= 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be >= 1.");

        Node temp = head;

        for(int i=1; i<index; i++){
            temp = temp.next;

            if(temp == null){
                throw new IndexOutOfBoundsException("Invalid index: " + index + ". No such position in the list.");
            }
        }
        return temp.data;
    }

    public boolean contains(T data){
        if (head == null) return false;

        Node temp = head;

        while (temp != null){

            if(data.equals(temp.data)) return true;
            temp = temp.next;

        }
        return false;
    }

    public int search(T data){

        if (head == null) return -1;

        Node temp = head;
        int index = 1;

        while (temp != null){

            if(data.equals(temp.data)) return index;
            temp = temp.next;
            index++;

        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void reverse() {

        if (head == null)
            throw new IndexOutOfBoundsException("List is empty.");

        Node curr = head;
        Node temp = null;

        while (curr != null) {
           temp = curr.prev;
           curr.prev = curr.next;
           curr.next = temp;
           curr = curr.prev;
        }
        Node oldHead = head;
        head = tail;
        tail = oldHead;
    }

    public void forwardTraversal(){
        Node temp = head;
        System.out.print("[");
        while (temp != null){
            System.out.print(temp.data);
            if(temp.next != null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.print("]");
    }

    public void reverseTraversal(){
        Node temp = tail;
        System.out.print("[");
        while (temp != null){
            System.out.print(temp.data);
            if(temp.prev != null) System.out.print(", ");
            temp = temp.prev;
        }
        System.out.print("]");
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
