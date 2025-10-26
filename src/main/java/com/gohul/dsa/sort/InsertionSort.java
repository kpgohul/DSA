package com.gohul.dsa.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] list){

        for(int i=1; i<list.length; i++){
            for(int j=i; j>0; j--){
                if(list[j-1] > list[j]){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {43423, 34532, 12, 1, 57, 0, 3, 123, 3232};
        sort(list);
        System.out.println(Arrays.toString(list));
    }
}
