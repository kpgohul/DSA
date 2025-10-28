package com.gohul.algorithm.dp;

public class UnBoundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        //recursion
        // return findOut(n-1, w, profit, weight);

        // recursion with dp
        // int[][] dp = new int[n][w+1];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return findOut2(n-1, w, profit, weight, dp);

        //tabulation
        // return tabulation(n, w, profit, weight);

        //mem - opti
        return memOpti(n, w, profit, weight);
    }

    public static int findOut(int index, int W, int[] profit, int[] weight){
        if(index == 0){
            return (W/weight[0]) * profit[0];
        }

        int notPick = findOut(index - 1, W, profit, weight);
        int pick = (W >= weight[index])? profit[index] + findOut(index, W - weight[index], profit, weight) : Integer.MIN_VALUE;

        return Math.max(notPick, pick);
    }

    public static int findOut2(int index, int W, int[] profit, int[] weight, int[][] dp){
        if(index == 0){
            return (W/weight[0]) * profit[0];
        }
        if(dp[index][W] != -1) return dp[index][W];

        int notPick = findOut2(index - 1, W, profit, weight, dp);
        int pick = (W >= weight[index])? profit[index] + findOut2(index, W - weight[index], profit, weight, dp) : Integer.MIN_VALUE;

        return dp[index][W] = Math.max(notPick, pick);
    }

    public static int tabulation(int n, int W, int[] profit, int[] weight){
        int[][] dp = new int[n][W+1];
        for(int i=0; i<=W; i++){
            dp[0][i] = (i/weight[0]) * profit[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=W; j++){
                int notPick = dp[i-1][j];
                int pick = (j >= weight[i])? profit[i] + dp[i][j - weight[i]]: Integer.MIN_VALUE;
                dp[i][j] = Math.max(notPick, pick);
            }
        }

        return dp[n-1][W];
    }

    public static int memOpti(int n, int W, int[] profit, int[] weight){
        int[] dp = new int[W+1];
        for(int i=0; i<=W; i++){
            dp[i] = (i/weight[0]) * profit[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=W; j++){
                int notPick = dp[j];
                int pick = (j >= weight[i])? profit[i] + dp[j - weight[i]]: Integer.MIN_VALUE;
                dp[j] = Math.max(notPick, pick);
            }
        }

        return dp[W];
    }
}
