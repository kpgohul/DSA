package com.gohul.dsa.sort;

import java.util.Arrays;

public class MergeSort {

    // Time complexity - n log base2 n

    public static int[] sort(int[] list){
        if(list.length == 1) return list;

        int mid = list.length / 2;

        int[] left = sort(Arrays.copyOfRange(list, 0, mid));
        int[] right = sort(Arrays.copyOfRange(list, mid, list.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right){
        int[] joined = new int[left.length + right.length];

        int i=0;
        int j=0;
        int k=0;

        while (i<left.length && j<right.length){
            if(left[i]<right[j]) joined[k++] = left[i++];
            else joined[k++] = right[j++];
        }
        while(i<left.length) joined[k++] = left[i++];
        while(j<right.length) joined[k++] = right[j++];

        return joined;
    }

    public static void main(String[] args) {
        int[] list = {43423, 34532, 12, 1, 57, 0, 3, 123, 3232};
        //1
//        list = sort(list);
//        System.out.println(Arrays.toString(list));

        //2
        inlineSort(0, list.length-1, list);
        System.out.println(Arrays.toString(list));
    }

    public static void inlineSort(int start, int end, int[] list){
        if(start>=end) return;

        int mid = (start + end) / 2;

        inlineSort(start, mid, list);
        inlineSort(mid+1, end, list);

        inlineMerge(start, end, list);
    }

    public static void inlineMerge(int start, int end, int[] list){
        int length = end - start + 1;
        int[] joined = new int[length];
        int mid = (start + end) / 2;

        int i = start;
        int j = mid +1;
        int k = 0;

        while(i<=mid && j<=end){
            if(list[i] < list[j]) joined[k++] = list[i++];
            else joined[k++] = list[j++];
        }

        while(i<=mid) joined[k++] = list[i++];
        while(j<=end) joined[k++] = list[j++];

        k=0;
        for(int st = start; st<=end; st++){
            list[st] = joined[k++];
        }
    }



}
