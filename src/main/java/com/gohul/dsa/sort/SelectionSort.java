package com.gohul.dsa.sort;

import java.util.Arrays;

public class SelectionSort {

    // time complexity - O(n power 2)

    public static void sort(int[] list){

        for(int i=0; i<list.length; i++){
            int minIndex = i;

            for(int j=i+1; j<list.length; j++){
                if(list[j]<list[minIndex]){
                    minIndex = j;
                }
            }

            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] list = {43423, 34532, 12, 1, 57, 0, 3, 123, 3232};
        sort(list);
        System.out.println(Arrays.toString(list));
    }
}
