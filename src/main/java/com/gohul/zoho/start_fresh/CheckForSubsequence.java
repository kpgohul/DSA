package com.gohul.zoho.start_fresh;

public class CheckForSubsequence {

    public static void main(String[] args) {

        String A1 = "AXY";
        String B1 = "YADXCP";

        String A2 = "gksrek";
        String B2 = "geeksforgeeks";

//        System.out.println(findOut(B1.length()-1, A1.length()-1, B1, A1));
//        System.out.println(findOut(B2.length()-1, A2.length()-1, B2, A2));

        System.out.println(tabulation(B1, A1));
        System.out.println(tabulation(B2, A2));



    }

    public static boolean findOut(int i, int j, String str1, String str2){
        if (j < 0) return true;
        if (i < 0) return false;


        if(str1.charAt(i) == str2.charAt(j)) return findOut(i-1, j-1, str1, str2);
        else return findOut(i-1, j, str1, str2);
    }

    public static boolean tabulation(String str1, String str2){
        boolean[][] dp = new boolean[str1.length() + 1][str2.length() + 1];

        for(int i=0; i <= str1.length(); i++) dp[i][0] = true;

        for(int i = 1; i<= str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){

                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[str1.length()][str2.length()];

    }
}
