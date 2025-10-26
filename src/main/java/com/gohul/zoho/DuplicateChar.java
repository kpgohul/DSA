package com.gohul.zoho;


public class DuplicateChar {

    public static void main(String[] args) {
        String given = "daas2s3werraar9232yuy9";


        System.out.println(findOut(given));
        findOut2(given);
    }

    public static String findOut(String given){
        int i = 0;

        while (i< given.length()){
            char curr = given.charAt(i);
            int count = given.length() -  given.replace(String.valueOf(given.charAt(i)), "").length();
            if(count > 1 && Character.isAlphabetic(curr)){
                given = given.replace(String.valueOf(given.charAt(i)), "");
                given = given.substring(0,i) + curr + given.substring(i);
            }
            i++;

        }
        i=0;
        given = new StringBuilder(given).reverse().toString();
        while (i< given.length()){
            char curr = given.charAt(i);
            int count = given.length() -  given.replace(String.valueOf(given.charAt(i)), "").length();
            if(count > 1 && Character.isDigit(curr)){
                given = given.replace(String.valueOf(given.charAt(i)), "");
                given = given.substring(0,i) + curr + given.substring(i);
            }
            i++;

        }
        return new StringBuilder(given).reverse().toString();
    }

    public static void findOut2(String given) {
        int[] assist = new int[256];
        for (int i = 0; i < given.length(); i++) {
            if (Character.isDigit(given.charAt(i))) assist[given.charAt(i)] = i;
        }

        for (int i = 0; i < given.length(); i++) {
            char curr = given.charAt(i);
            if (Character.isAlphabetic(curr) && assist[curr] != Integer.MAX_VALUE) {
                System.out.print(curr);
                assist[curr] = Integer.MAX_VALUE;
            } else if (Character.isDigit(curr) && i == assist[curr]) {
                System.out.print(curr);
            }

        }
    }


}
