package com.gohul.zoho.start_fresh;

public class SingleNonDuplicate {

    public static void main(String[] args) {

        System.out.println(findOut(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(findOut(new int[]{3,3,7,7,10,11,11}));

    }

    public static int findOut(int[] list){

        int start = 0, end = list.length - 1;

        while (start < end){

            int mid = (start + end) / 2;

            if(mid % 2 != 0) mid --;

            if(list[mid] == list[mid + 1]) start+=2;

            else end = mid;
        }

        return list[start];
    }
}
