package com.gohul.zoho;

import java.util.Scanner;

public class ZohoPattern {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str ="Z0HO";
        int n = str.length();
        int st = 0;

        for(int i=0; i<n/2; i++){
                for(int k=0; k<i; k++) System.out.print("  ");
                System.out.print(str.charAt(st)+" ");
                for(int k=0; k < n/2 - i - 1; k++) System.out.print("  ");
                System.out.print(str.charAt(st)+" ");
                for(int k=0; k < n/2 - i - 1; k++) System.out.print("  ");
                System.out.print(str.charAt(st)+" ");
            st++;
            System.out.println();

        }

        for(int i=0; i<str.length(); i++){
            if(str.length() % 2 == 0 && i == n/2) System.out.print("* ");
            System.out.print(str.charAt(i) + " ");
        }
        if(str.length() % 2 != 0) st++;
        System.out.println();

        for(int i=n/2 - 1; i>=0; i--){
            for(int k=0; k<i; k++) System.out.print("  ");
            System.out.print(str.charAt(st)+" ");
            for(int k=0; k < n/2 - i - 1; k++) System.out.print("  ");
            System.out.print(str.charAt(st)+" ");
            for(int k=0; k < n/2 - i - 1; k++) System.out.print("  ");
            System.out.print(str.charAt(st)+" ");
            st++;
            System.out.println();

        }

    }




}
