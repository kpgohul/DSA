package com.gohul.zoho.start_fresh;

import java.util.Arrays;

public class MoveZero {

    public static void main(String[] args) {

        int[] list = {1, 2, 0, 4, 3, 0, 5, 0};

        int j = 0;

        for(int i=0; i<list.length; i++){

            if(list[i] != 0){
                if(i != j){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(list));
    }
}
