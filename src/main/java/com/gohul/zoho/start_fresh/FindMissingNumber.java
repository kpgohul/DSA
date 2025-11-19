package com.gohul.zoho.start_fresh;

public class FindMissingNumber {

    public static void main(String[] args) {

        System.out.println(findMissing(new int[]{8, 2, 4, 5, 3, 7, 1}));
    }

    public static int findMissing(int[] arr) {
        int n = arr.length + 1; // Because one number is missing
        int total = n * (n + 1) / 2;

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return total - sum;
    }
}
