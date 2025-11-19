package com.gohul.zoho.start_fresh;

public class ExtraElementIndex {

    public static void main(String[] args) {
        int[] a1 = {2, 4, 6, 8, 9, 10, 12};
        int[] a2 = {2, 4, 6, 8, 10, 12};
        System.out.println(findOut(a1, a2)); // Output: 4

        int[] b1 = {3, 5, 7, 8, 11, 13};
        int[] b2 = {3, 5, 7, 11, 13};
        System.out.println(findOut(b1, b2)); // Output: 3

        int[] c1 = {3, 5};
        int[] c2 = {3};
        System.out.println(findOut(c1, c2)); // Output: 1
    }

    public static int findOut(int[] list1, int[] list2){

        if(list1.length == list2.length) return -1;


        int i =0, j=list2.length - 1;
        int index = list1.length - 1;

        while (i <= j){
            int mid = (i + j) / 2;

            if(list1[mid] == list2[mid]) i = mid + 1;
            else {
                index = mid;
                j = mid - 1;
            }
        }
        return index;
    }
}
