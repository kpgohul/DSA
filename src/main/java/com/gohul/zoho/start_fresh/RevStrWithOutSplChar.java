package com.gohul.zoho.start_fresh;

public class RevStrWithOutSplChar {

    public static void main(String[] args) {

        String str = "A#B*C&D@E";

        System.out.println(reverse(str));

    }



    public static String reverse(String str) {

        char[] arr = str.toCharArray();
        int start = 0, end = arr.length - 1;

        while (start < end) {

            while (start < end && !Character.isLetter(arr[start])) start++;
            while (start < end && !Character.isLetter(arr[end])) end--;

            if (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return new String(arr);
    }
}

