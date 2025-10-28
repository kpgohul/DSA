package com.gohul.algorithm.dp;

public class LongestCommonSubsequence {

    public static int lcs(String s, String t) {
        //1
        // return findOut1(s.length()-1,t.length()-1,s,t);
        //2
        // int[][] dp=new int[s.length()][t.length()];
        // for(int[] td:dp) Arrays.fill(td,-1);
        // return findOut(s.length()-1,t.length()-1,s,t,dp);
        //3
        // return tabulation(s,t);
        //4
        return memOpti(s,t);
    }
    public static int findOut1(int index1,int index2,String str1,String str2)
    {
        if(index1<0||index2<0) return 0;
        if(str1.charAt(index1)==str2.charAt(index2)) return 1+findOut1(index1-1,index2-1,str1,str2);
        return Math.max(findOut1(index1-1,index2,str1,str2),findOut1(index1,index2-1,str1,str2));
    }

    public static int findOut(int i, int j, String str1, String str2, int[][] dp){
        if(i<0||j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i)==str2.charAt(j)) return 1+findOut(i-1,j-1,str1,str2, dp);
        return dp[i][j] = Math.max(findOut(i-1,j,str1,str2, dp),findOut(i,j-1,str1,str2, dp));
    }

    public static int tabulation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m   + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static int memOpti(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + dp[j - 1];
                } else {
                    curr[j] = Math.max(dp[j], curr[j - 1]);
                }
            }
            dp=curr;
        }

        return dp[n];
    }

    public static String getLCSString(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m   + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder result = new StringBuilder();

        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                result.insert(0, str1.charAt(i - 1));
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return result.toString();
    }

}
