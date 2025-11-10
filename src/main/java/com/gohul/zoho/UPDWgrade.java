package com.gohul.zoho;

public class UPDWgrade {

    public static void main(String[] args) {
        String v1 = "9.1.0";
        String v2 = "9.0.24";
        System.out.println(findOut(v1, v2));
    }

    public static String findOut(String str1, String str2){

        int i1 = 0, i2 = 0;

        while (i1 < str1.length() || i2 < str2.length()) {
            int j1 = i1;
            int j2 = i2;

            // find the next dot in str1
            while (j1 < str1.length() && str1.charAt(j1) != '.') j1++;
            // find the next dot in str2
            while (j2 < str2.length() && str2.charAt(j2) != '.') j2++;

            // extract current version parts
            int s1 = 0, s2 = 0;
            if (i1 < str1.length()) s1 = Integer.parseInt(str1.substring(i1, j1));
            if (i2 < str2.length()) s2 = Integer.parseInt(str2.substring(i2, j2));

            if (s1 < s2) return "Upgraded";
            if (s1 > s2) return "Downgraded";

            // move past '.'
            i1 = j1 + 1;
            i2 = j2 + 1;
        }
        return "Equal";
    }
}
