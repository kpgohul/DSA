package com.gohul.algorithm.dp;

public class RodCutting {

    public static int cutRod(int price[], int n) {
        // return
        // return findOut(price.length - 1, n, price);

        // recurr - dp
        // int[][] dp = new int[price.length][n+1];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return findOut2(price.length - 1, n, price, dp);

        //tabulation
        return tabulation(n, price);
    }

    public static int findOut(int index, int n, int[] price){

        if(index == 0){
            return n * price[index];
        }

        int notPick = findOut(index - 1, n, price);
        int pick = Integer.MIN_VALUE;
        if (index + 1 <= n) {
            pick = price[index] + findOut(index, n - (index + 1), price);
        }
        return Math.max(notPick, pick);
    }

    public static int findOut2(int index, int n, int[] price, int[][] dp){

        if(index == 0){
            return n * price[index];
        }
        if(dp[index][n] != -1) return dp[index][n];

        int notPick = findOut2(index - 1, n, price, dp);
        int pick = Integer.MIN_VALUE;
        if (index + 1 <= n) {
            pick = price[index] + findOut2(index, n - (index + 1), price, dp);
        }
        return dp[index][n] = Math.max(notPick, pick);
    }

    public static int tabulation(int n, int[] price){
        int[][] dp = new int[price.length][n + 1];

        for(int i=0; i<=n; i++){
            dp[0][i] = i * price[0];
        }

        for(int i=1; i<price.length; i++){
            for(int j=0; j<=n; j++){
                int notPick = dp[i-1][j];
                int pick = (j >= i+1)? price[i] + dp[i][j- (i+1)]: Integer.MIN_VALUE;
                dp[i][j] = Math.max(notPick, pick);
            }
        }

        return dp[price.length - 1][n];
    }


}
