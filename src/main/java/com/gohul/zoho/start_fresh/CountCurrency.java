package com.gohul.zoho.start_fresh;

public class CountCurrency {

    public static void main(String[] args) {

        int[] notes = new int[]{ 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
        int[] count = new int[9];

        int amount = 2456;

        for(int i=0; i<9; i++){
            if(amount >= notes[i]){
                count[i] = amount / notes[i];
                amount %= notes[i];
            }
        }

        System.out.println("Coin coin:: ");

        for(int i=0; i<9; i++){
            if(count[i] > 0) System.out.println(notes[i]+" count:: "+count[i]);
        }

    }
}
