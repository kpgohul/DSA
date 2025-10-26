package com.gohul.dsa.search;

import java.util.Arrays;

public class LinearSearch {

    // time complexity (Worst Case) - O(n)

    public static <T> int find(T[] list, T target){

        for(int i=0; i<list.length; i++){
            if(list[i].equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] list = {1,2,2,45,366,4634,5,4,564,6,9};
        Integer target = 9;
        System.out.println(find(list, target));
    }
}
