package com.gohul.zoho.start_fresh;

public class TwistedPrime {

    public static boolean isPrime(int n){

        if(n < 2)  return false;

        for(int i=2; Math.pow(i, 2) <= n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {

        int n = 97;

        System.out.println(findOut(n, Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString())));

    }

    public static boolean findOut(int n1, int n2){

        return isPrime(n1) && isPrime(n2);
    }
}
