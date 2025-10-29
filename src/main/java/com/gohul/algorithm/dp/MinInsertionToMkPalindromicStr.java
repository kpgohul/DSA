package com.gohul.algorithm.dp;

public class MinInsertionToMkPalindromicStr {

    public static int minInsertion(String str) {
        // recurr
        // int len =  longestPalindromicSubsequence(str.length() - 1, str.length() - 1, str, new StringBuilder(str).reverse().toString());
        // return str.length() - len;

        // recurr - dp
        // int[][] dp = new int[str.length()][str.length()];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // int len = longestPalindromicSubsequence2(str.length() - 1, str.length() - 1, str, new StringBuilder(str).reverse().toString(), dp);
        // return str.length() - len;

        // tabulation
        // return str.length() - tabulation(str, new StringBuilder(str).reverse().toString());

        // mem-opti
        return str.length() - meOpti(str, new StringBuilder(str).reverse().toString());

    }


    public static int longestPalindromicSubsequence(int i, int j, String str1, String str2){
        if(i < 0 || j < 0) return 0;

        if(str1.charAt(i) == str2.charAt(j))
            return 1 + longestPalindromicSubsequence(i-1, j-1, str1, str2);
        return Math.max(longestPalindromicSubsequence(i-1, j, str1, str2), longestPalindromicSubsequence(i, j-1, str1, str2));
    }


    public static int longestPalindromicSubsequence2(int i, int j, String str1, String str2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j))
            return 1+ longestPalindromicSubsequence2(i-1, j-1, str1, str2, dp);
        return Math.max(longestPalindromicSubsequence2(i-1, j, str1, str2, dp), longestPalindromicSubsequence2(i, j-1, str1, str2, dp));
    }

    public static int tabulation(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[str2.length()][str2.length()];
    }

    public static int meOpti(String str1, String str2){
        int[] dp = new int[str2.length() + 1];

        for(int i=1; i<=str1.length(); i++){
            int[] curr = new int[str2.length() + 1];
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) curr[j] = 1 + dp[j-1];
                else curr[j] = Math.max(dp[j], curr[j-1]);
            }
            dp = curr;
        }

        return dp[str2.length()];
    }


}
