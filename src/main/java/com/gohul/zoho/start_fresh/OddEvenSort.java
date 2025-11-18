package com.gohul.zoho.start_fresh;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OddEvenSort {

    public static void main(String[] args) {

        int[] list = {1, 2, 3, 5, 4, 7, 10};

        int[] even = new int[list.length];

        int[] odd = new int[list.length];

        int i1 = 0, i2 = 0;
        for(int i: list){

            if(i%2 == 0) even[i1++] = i;
            else odd[i2++] = i;

        }

        for(int i=1; i<i2; i++){

            int j = i;

            while (j>=1){

                if(odd[j] > odd[j-1]){
                    int temp = odd[j];
                    odd[j] = odd[j-1];
                    odd[j-1] = temp;
                    j--;
                }
                else break;
            }
        }

        for(int i=1; i<i1; i++){

            int j = i;

            while (j>=1){

                if(even[j] < even[j-1]){
                    int temp = even[j];
                    even[j] = even[j-1];
                    even[j-1] = temp;
                    j--;
                }
                else break;
            }
        }

        IntStream.range(0, i2).forEach(i -> System.out.print(odd[i] + " "));
        IntStream.range(0, i1).forEach(i -> System.out.print(even[i] + " "));



    }
}
