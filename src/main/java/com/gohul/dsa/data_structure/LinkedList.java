package com.gohul.dsa.data_structure;

import java.util.Iterator;

/**
 * @param index position starting from 1
 */
public class LinkedList<T> implements Iterable<T> {

    private class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private int size;


    public LinkedList(){
        head = null;
        size = 0;
    }

    public void insertAtFirst(T data){
        Node newNode = new Node(data);

        if(head == null) head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtLast(T data){
        Node newNode = new Node(data);

        if(head == null) head = newNode;
        else{
            Node lastNode = head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    public void deleteAtFirst(){
        if(head == null) throw new IndexOutOfBoundsException("List is empty");
        head = head.next;
        size--;
    }

    public void deleteAtLast() {
        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");

        if (head.next == null) { // Only one element
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }


    public void insertAtPos(int index, T data) {

        if (index <= 0)
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be >= 1.");

        if (index == 1) {
            insertAtFirst(data);
            return;
        }

        Node temp = head;
        Node newNode = new Node(data);

        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
            if (temp == null)
                throw new IndexOutOfBoundsException("Invalid index: " + index + ". No such position in the list.");
        }

        newNode.next = temp.next;
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

        Node current = head;
        Node previous = null;

        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.next;

            if (current == null)
                throw new IndexOutOfBoundsException("Invalid index: " + index + ". No such position in the list.");
        }

        previous.next = current.next;
        size--;
    }

    public void updateAtPos(int index, T data){

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

    public void reverse(){

        if (head == null)
            throw new IndexOutOfBoundsException("List is empty.");

        Node pre = null;
        Node curr = head;
        Node next = head.next;

        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
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
