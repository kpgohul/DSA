package com.gohul.dsa.data_structure;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node top;
    private int size;


    private class Node{
        T data;
        Node prev;
        Node(T data){
            this.data = data;
            prev = null;
        }
    }

    public Stack(){
        size = 0;
        top = null;
    }

    public void push(T data){
        Node newNode = new Node(data);
        if(top != null){
            newNode.prev = top;
        }
        top = newNode;
        size++;
    }

    public T pop(){
        if(top == null) throw new RuntimeException("Stack underflow!");
        T data = top.data;
        top = top.prev;
        size--;
        return data;
    }

    public T peek(){
        if(top == null) throw new RuntimeException("Stack underflow!");
        return top.data;
    }

    public boolean consist(T data){
        Node temp = top;

        while (temp != null){
            if(temp.data.equals(data)) return true;
            temp = temp.prev;
        }
        return false;
    }




    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node temp = top;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
               T data = temp.data;
               temp = temp.prev;
               return data;
            }
        };
    }
}
