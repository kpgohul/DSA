package com.gohul.dsa.data_structure;

import java.util.Iterator;

public class DoublyCircularLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        T data;
        Node next;
        Node prev;

        Node(T data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
    public DoublyCircularLinkedList(){
        head = tail = null;
        size = 0;
    }

    public void insertAtFirst(T data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;

            head.prev = tail;
            head.next = tail;
        }
        else{
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;

            head = newNode;
        }
        size++;
    }

    public void insertAtLast(T data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;

            head.prev = tail;
            head.next = tail;
        }
        else{
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;

            tail = newNode;
        }
        size++;

    }

    public void deleteAtFirst(){
        if(head == null) throw new IndexOutOfBoundsException("List is Empty");
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
        head.prev = tail;
        size--;
    }

    public void deleteAtLast(){
        if(head == null) throw new IndexOutOfBoundsException("List is Empty");
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
    }

    public void insertAtPos(int index, T data){

        if(head == null){
            if(index == 1){
                insertAtFirst(data);
                return;
            } else {
                throw new IndexOutOfBoundsException("List is Empty");
            }
        }
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

        for(int i=1; i<index - 1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

    }

    public void deleteAtPos(int index){

        if(head == null)
            throw new IndexOutOfBoundsException("List is Empty");

        if (index <= 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be >= 1.");

        if (index > size)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Exceeds list size.");

        if (index == 1) {
            deleteAtFirst();
            return;
        }
        if (index == size) {
            deleteAtLast();
            return;
        }
        Node curr = head;

        for(int i=1; i<index; i++){
            curr = curr.next;
        }

        Node prev = curr.prev;
        prev.next = curr.next;
        curr.next.prev = prev;

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

    public void forwardTraverse(){
        if(head == null){
            System.out.println("[]");
            return;
        }

        Node temp = head;
        System.out.print("[");
        do{
            System.out.print(temp.data);
            temp = temp.next;
            if(temp != head) System.out.print(", ");
        }while(temp != head);
        System.out.println("]");
    }

    public void reverseTraversal(){
        if(head == null){
            System.out.println("[]");
            return;
        }

        Node temp = tail;
        System.out.print("[");
        do{
            System.out.print(temp.data);
            temp = temp.prev;
            if(temp != tail) System.out.print(", ");
        }while(temp != tail);
        System.out.println("]");

    }




    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node temp = head;
            boolean firePass = true;

            @Override
            public boolean hasNext() {
                return temp != null && (firePass || temp != head);
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                firePass = false;
                return data;
            }
        };
    }


}
