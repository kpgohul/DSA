package com.gohul.dsa.data_structure;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public Queue(){
        front = rear = null;
        size  = 0;
    }

    public void enqueue(T data){
        Node newNode = new Node(data);
        if(front == null || rear == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue(){
        if(front == null || rear == null) throw new RuntimeException("Queue is empty.");
        T data = front.data;
        if(front == rear) front = rear = null;
        else front = front.next;
        size--;
        return data;
    }

    public boolean contains(T data){
        Node temp = front;
        while(temp != null){
            if(temp.data.equals(data)) return true;
            temp = temp.next;
        }
        return false;
    }

    public int size(){
        return size;
    }


    public T getFront(){
        if(front != null){
            return front.data;
        }
        return null;
    }

    public T getRear(){
        if(rear != null){
            return rear.data;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = front;
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

}

