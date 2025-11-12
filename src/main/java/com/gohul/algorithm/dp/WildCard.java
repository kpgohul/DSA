package com.gohul.algorithm.dp;

public class WildCard {
    public static boolean wildcardMatching(String pattern, String text) {
        //recurr
        // return findOut(pattern.length() - 1, text.length() - 1, pattern, text);
        // int[][] dp = new int[pattern.length()][text.length()];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return findOut2(pattern.length() - 1, text.length() - 1, pattern, text, dp);
        return tabulation(pattern.length(), text.length(), pattern, text);

    }

    public static boolean findOut(int i, int j, String str1, String str2){
        if(i<0 && j<0) return true;
        if(i < 0 && j >= 0) return false;
        if (j < 0) {
            for (int k = 0; k <= i; k++) {
                if (str1.charAt(k) != '*') return false;
            }
            return true;
        }

        if(str1.charAt(i) == str2.charAt(j) || str1.charAt(i) == '?')
            return findOut(i-1, j-1, str1, str2);
        if(str1.charAt(i) == '*')
            return findOut(i-1, j, str1, str2) || findOut(i, j-1, str1, str2);
        return false;
    }

    public static boolean findOut2(int i, int j, String str1, String str2, int[][] dp){

        if(i<0 && j<0) return true;
        if(i < 0 && j >= 0) return false;
        if (j < 0) {
            for (int k = 0; k <= i; k++) {
                if (str1.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean res = false;
        dp[i][j] = 0;
        if(str1.charAt(i) == str2.charAt(j) || str1.charAt(i) == '?'){
            res = findOut2(i-1, j-1, str1, str2, dp);
            dp[i][j] = (res)? 1: 0;
            return res;
        }
        if(str1.charAt(i) == '*'){
            res = findOut2(i-1, j, str1, str2, dp) || findOut2(i, j-1, str1, str2, dp);
            dp[i][j] = (res)? 1: 0;
            return res;
        }
        return false;

    }

    public static boolean tabulation(int n1, int n2, String str1, String str2){
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            if (str1.charAt(i - 1) == '*')
                dp[i][0] = dp[i - 1][0];
            else
                break;
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1) || str1.charAt(i - 1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(str1.charAt(i - 1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[n1][n2];
    }
}
