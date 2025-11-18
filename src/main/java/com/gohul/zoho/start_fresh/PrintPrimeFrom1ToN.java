package com.gohul.zoho.start_fresh;

public class PrintPrimeFrom1ToN {

    public static void main(String[] args) {

        int n = 150;

        for(int i=2; i<=n; i++){
            if(isPrime(i)) System.out.print(i + " ");
        }

    }

    public static boolean isPrime(int n){

        if(n < 2) return false;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
