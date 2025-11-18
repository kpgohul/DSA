package com.gohul.zoho.start_fresh;

public class MakeADistinctDigitArray {

    public static void main(String[] args) {

        int[] list = {131, 11, 48};
        boolean[] assist = new boolean[10];

        for(int n: list){

            int temp = n;
            while(temp > 0){

                int digit = temp%10;
                assist[digit] = true;
                temp/=10;
            }
        }

        for (int i=0; i<assist.length; i++){
            if(assist[i]) System.out.print(i+" ");
        }
    }
}
