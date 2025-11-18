package com.gohul.zoho.start_fresh;

public class SmallestMissingPrime {

    public static void main(String[] args) {

        int[] arr1 = {9, 11, 4, 2, 3, 7, 0, 1};
        int[] arr2 = {3, 0, 2, 5};

        System.out.println(findOut(arr1)); // Output: 5
        System.out.println(findOut(arr2)); // Output: No prime number missing

    }

    public static String findOut(int[] list){

        int max = Integer.MIN_VALUE;

        for(int i: list)
            max = Math.max(max, i);

        boolean[] present = new boolean[max + 1];

        for(int i: list)
            present[i] = true;

        for(int i=2; i<=max; i++){
            if(isPrime(i) && !present[i]) return String.valueOf(i);
        }

        return "No Prime number missing";

    }

    public static boolean isPrime(int n){

        if(n < 2)  return false;

        for(int i=2; Math.pow(i, 2) <= n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }
}
