package com.gohul.dsa.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] list){

        for(int i=1; i<list.length; i++){
            boolean isSwapped = false;
            for(int j=0; j<list.length - i; j++){
                if(list[j] > list[j+1]){
                    isSwapped = true;
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] list1 = {8, 9, 10, 11, 1, 2, 3, 4, 5, 6, 7};
        int[] list2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        // Time sorting for list1
        Instant start1 = Instant.now();
        sort(list1);
        Instant end1 = Instant.now();

        // Time sorting for list2
        Instant start2 = Instant.now();
        sort(list2);
        Instant end2 = Instant.now();

        // Print sorted arrays and time taken
        System.out.println("List1 sorted: " + Arrays.toString(list1) +
                " by taking " + Duration.between(start1, end1).toNanos() + " ns");
        System.out.println("List2 sorted: " + Arrays.toString(list2) +
                " by taking " + Duration.between(start2, end2).toNanos() + " ns");
    }

}
