package com.gohul.dsa.data_structure;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T>{

    private static final int INITIAL_CAPACITY = 10;
    private T[] list;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public DynamicArray() {

        list = (T[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
    }

    public void add(T element){
        if(size == capacity) expandArray();
        list[size++] = element;
    }

    public void insert(int index, T element){
        if(size == capacity) expandArray();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index + ". It must be between 0 and " + (size) + "."
            );
        for(int i = size -1; i>=index; i--){
            list[i+1] = list[i];
        }
        list[index] = element;
        size++;
    }

    public void update(int index, T element){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index + ". It must be between 0 and " + (size - 1) + "."
            );
        list[index] = element;
    }

    public void delete(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index + ". It must be between 0 and " + (size - 1) + "."
            );
        for(int i=index + 1; i<=size; i++){
            list[i - 1] = list[i];
        }
        size--;
        shrinkArray();
    }

    public int length(){
        return size;
    }

    private void expandArray(){
        capacity *= 2;
        list = Arrays.copyOf(list, capacity);
    }

    private void shrinkArray(){
        if(capacity > INITIAL_CAPACITY && capacity > 3*size){
            capacity /= 2;
            list = Arrays.copyOf(list, capacity);
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return list[index++];
            }
        };
    }
}
