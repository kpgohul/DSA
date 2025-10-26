package com.gohul.dsa.search;

public class BinarySearch {

    // Time complexity (Worst case) - log base2 n

    public static int search(int start, int end, int target, int[] list){

        if(end < start) return -1;

        int mid = ((start + end) + 1 )/ 2;

        if(list[mid] == target)
            return mid;

        if(list[mid] > target)
            return search(start, mid -1, target, list);
        else
            return search(mid + 1, end, target, list);
    }

    public static void main(String[] args) {

        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = 8;

        System.out.println(search(0, list.length -1, target, list));
    }
}
