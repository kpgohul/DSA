package com.gohul.zoho;

public class PatternQs {

    public static void main(String[] args) {
        int height = 11;

        if(height % 2 == 0) solveEven(height);
        else solveOdd(height);
    }

    public static void solveEven(int height){

        for(int i =1; i <= height/2; i++){
            int start = height / 2 - i;
            int mid = height / 2;
            int end = height / 2  + i;
            char curr = '1';
            for(int j = 1; j<=start; j++) System.out.print("  ");
            for(int j = start; j<= mid - 1; j++){
                System.out.print(curr+" ");
                curr = (curr == '1')? '*': '1';
            }
            for(int j=mid + 1; j<=end; j++){
                curr = (curr == '1')? '*': '1';
                System.out.print(curr+" ");
            }
            System.out.println();
        }
        for(int i =height/2; i >= 1; i--){
            int start = height / 2 - i;
            int mid = height / 2;
            int end = height / 2  + i;
            char curr = '1';
            for(int j = 1; j<=start; j++) System.out.print("  ");
            for(int j = start; j<= mid - 1; j++){
                System.out.print(curr+" ");
                curr = (curr == '1')? '*': '1';
            }
            for(int j=mid + 1; j<=end; j++){
                curr = (curr == '1')? '*': '1';
                System.out.print(curr+" ");
            }
            System.out.println();
        }
    }

    public static void solveOdd(int height){

        int row = 1;
        for(int i=1; i<=height/2; i++){
            for(int j=1; j<=height/2 - i; j++) System.out.print("  ");
            for(int j=1; j<=row; j++) System.out.print((j % 2 == 1)? "1 ": "* ");
            row += 2;
            System.out.println();
        }
        row -=4;
        for(int i=height/2 - 1; i>=1; i--){
            for(int j=1; j<=height/2 - i; j++) System.out.print("  ");
            for(int j=1; j<=row; j++) System.out.print((j % 2 == 1)? "1 ": "* ");
            row -= 2;
            System.out.println();
        }
    }
}
