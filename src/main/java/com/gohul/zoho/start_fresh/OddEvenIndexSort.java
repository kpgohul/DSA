package com.gohul.zoho.start_fresh;

import java.util.Arrays;

public class OddEvenIndexSort {

    public static void main(String[] args) {

        int[] list = {1, 2, 3, 5, 4, 7, 10, 11, 0, 121, 100, 99, 555, 44};

        for(int i=2; i<list.length; i+=2){
            int j = i;
            while( j>=2 && list[j] > list[j-2]){

                int temp = list[j];
                list[j] = list[j-2];
                list[j-2] = temp;
                j-=2;

            }
        }

        for(int i=3; i<list.length; i+=2){
            int j = i;
            while( j>=3 && list[j] < list[j-2]){

                int temp = list[j];
                list[j] = list[j-2];
                list[j-2] = temp;
                j-=2;

            }
        }



        System.out.println(Arrays.toString(list));
    }
}
