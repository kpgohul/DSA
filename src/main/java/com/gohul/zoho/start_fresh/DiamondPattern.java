package com.gohul.zoho.start_fresh;

import java.util.Scanner;

public class DiamondPattern {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number:: ");
        int n = s.nextInt();

        int space = n -1;

        for(int i=1; i<=n; i++){
            for(int j = 1; j<=space; j++) System.out.print(" ");
            for(int j=1; j<=i; j++) System.out.print("* ");
            System.out.println();
            space--;
        }

        space = 0;
        for(int i=n; i>=1; i--){
            for(int j = 1; j<=space; j++) System.out.print(" ");
            for(int j=1; j<=i; j++) System.out.print("* ");
            System.out.println();
            space++;
        }



    }


}
