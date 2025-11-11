package com.gohul.algorithm.dp;

public class SubsequenceCont {
    public static int distinctSubsequences(String str, String sub) {
        // return recurr(str.length() - 1, sub.length() - 1, str, sub);

        // int[][] dp = new int[str.length()][sub.length()];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return recurrWithDp(str.length() - 1, sub.length() - 1, str, sub, dp);
        // return tabulation(str.length(), sub.length(), str, sub);
        // return memOpti(str.length(), sub.length(), str, sub);
        return memOpti2(str.length(), sub.length(), str, sub);


    }

    public static int recurr(int indexi, int indexj, String str1, String str2){
        if(indexj < 0) return 1;
        if(indexi < 0) return 0;

        if(str1.charAt(indexi) == str2.charAt(indexj)){
            return recurr(indexi -1, indexj - 1, str1, str2) + recurr(indexi - 1, indexj, str1, str2);
        }
        return recurr(indexi - 1, indexj, str1, str2);
    }


    public static int recurrWithDp(int indexi, int indexj, String str1, String str2, int[][] dp){
        if(indexj < 0) return 1;
        if(indexi < 0) return 0;

        if(dp[indexi][indexj] != -1) return dp[indexi][indexj];
        if(str1.charAt(indexi) == str2.charAt(indexj)){
            return recurrWithDp(indexi -1, indexj - 1, str1, str2, dp) + recurrWithDp(indexi - 1, indexj, str1, str2, dp);
        }
        return dp[indexi][indexj] = recurrWithDp(indexi - 1, indexj, str1, str2, dp);
    }

    public static int tabulation(int n1, int n2, String str1, String str2) {
        int[][] dp = new int[n1 + 1][n2 + 1];
        int MOD = 1000000007;

        for(int i = 0; i <= n1; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i-1][j] % MOD;
                }
            }
        }
        return dp[n1][n2];
    }

    public static int memOpti(int n1, int n2, String str1, String str2) {
        int[] dp = new int[n2 + 1];
        int MOD = 1000000007;

        dp[0] = 1;

        for(int i = 1; i <= n1; i++) {
            dp[0] = 1;
            int[] curr = new int[n2 + 1];

            for(int j = 1; j <= n2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    curr[j] = (dp[j-1] + dp[j]) % MOD;
                } else {
                    curr[j] = dp[j] % MOD;
                }
            }
            dp =curr;
        }
        return dp[n2];
    }

    public static int memOpti2(int n1, int n2, String str1, String str2) {
        int[] dp = new int[n2 + 1];
        int MOD = 1000000007;

        dp[0] = 1;

        for(int i = 1; i <= n1; i++) {

            for(int j = n2; j >= 1; j--) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[j] = (dp[j-1] + dp[j]) % MOD;
                } else {
                    dp[j] = dp[j] % MOD;
                }
            }
        }
        return dp[n2];
    }
}
