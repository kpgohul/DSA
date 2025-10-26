package com.gohul.dsa.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int low, int heigh, int[] list){
        if(low >= heigh) return;

        int start = low;
        int end = heigh;
        int mid = (start + end) / 2;

        int pivot = list[mid];
        while(start<=end){

            while(list[start] < pivot) start++;
            while(list[end] > pivot) end--;

            if(start<=end){
                int temp = list[start];
                list[start] = list[end];
                list[end] = temp;

                start++; end--;
            }
        }
        sort(low, end, list);
        sort(start, heigh, list);
    }

    public static void main(String[] args) {
        int[] list = {43423, 34532, 12, 1, 57, 0, 3, 123, 3232};
        sort(0, list.length - 1, list);
        System.out.println(Arrays.toString(list));
    }


}
