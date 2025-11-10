package com.gohul.algorithm.dp;

public class ShortestCommonSuperSequence {

    public static String shortestSupersequence(String a, String b) {

        return tabulation(a.length(), b.length(), a, b);
    }

    public static String tabulation(int n1, int n2, String str1,String str2){
        int[][] dp = new int[n1+1][n2+1];


        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        String res = "";
        int i = n1;
        int j= n2;

        while(i>=1 || j>=1){
            if(j <= 0){
                res = str1.charAt(i-1) + res;
                i--;
            }
            else if(i <= 0){
                res = str2.charAt(j-1) + res;
                j--;
            }
            else if(str1.charAt(i-1) == str2.charAt(j-1)){
                res = str1.charAt(i-1) + res;
                i--;
                j--;
            }
            else if(dp[i][j-1] < dp[i-1][j]){
                res = str1.charAt(i-1) + res;
                i--;
            }
            else{
                res = str2.charAt(j-1) + res;
                j--;
            }
        }
        return res;

    }
}
