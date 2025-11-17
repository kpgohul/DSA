package com.gohul.algorithm.dp;

public class BuyAndSellStock4 {

    public static int maximumProfit(int[] prices, int n, int k)
    {
        //recurr
        // return findOut(0, 1, k, prices);

        //recurr + dp
        // int[][][] dp = new int[n][2][k + 1];
        // for(int[][] tt: dp){
        //     for(int[] t: tt) Arrays.fill(t, -1);
        // }

        // return findOut(0, 1, k, prices, dp);

        //tabulation
        // return tabulation(n, k, prices);

        //memopti
        return memopti(n, k, prices);

    }

    public static int findOut(int index, int canBuy, int maxBuy, int[] prices){
        if(index == prices.length || maxBuy == 0) return 0;

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(
                    findOut(index + 1, 0, maxBuy, prices) - prices[index],
                    findOut(index + 1, 1, maxBuy, prices)
            );
        }
        else{
            profit = Math.max(
                    prices[index] + findOut(index + 1, 1, maxBuy - 1, prices),
                    findOut(index + 1, 0, maxBuy, prices)
            );
        }

        return profit;
    }

    public static int findOut(int index, int canBuy, int maxBuy, int[] prices, int[][][] dp){
        if(index == prices.length || maxBuy == 0) return 0;
        if(dp[index][canBuy][maxBuy] != -1) return dp[index][canBuy][maxBuy];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(
                    findOut(index + 1, 0, maxBuy, prices, dp) - prices[index],
                    findOut(index + 1, 1, maxBuy, prices, dp)
            );
        }
        else{
            profit = Math.max(
                    prices[index] + findOut(index + 1, 1, maxBuy - 1, prices, dp),
                    findOut(index + 1, 0, maxBuy, prices, dp)
            );
        }

        return dp[index][canBuy][maxBuy] = profit;
    }

    public static int tabulation(int n, int maxBuy, int[] prices){

        int[][][] dp = new int[n + 1][2][maxBuy + 1];

        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for(int k=1; k<=maxBuy; k++){
                    int profit = 0;
                    if(j == 1){
                        profit = Math.max(
                                -prices[i] + dp[i+1][0][k],
                                dp[i+1][1][k]
                        );
                    }
                    else{
                        profit = Math.max(
                                prices[i] + dp[i+1][1][k-1],
                                dp[i+1][0][k]
                        );
                    }
                    dp[i][j][k] = profit;
                }
            }
        }

        return dp[0][1][maxBuy];
    }

    public static int memopti(int n, int maxBuy, int[] prices){

        int[][] dp = new int[2][maxBuy + 1];

        for(int i = n-1; i>=0; i--){
            int[][] curr = new int[2][maxBuy + 1];
            for(int j=0; j<=1; j++){
                for(int k=1; k<=maxBuy; k++){
                    int profit = 0;
                    if(j == 1){
                        profit = Math.max(
                                -prices[i] + dp[0][k],
                                dp[1][k]
                        );
                    }
                    else{
                        profit = Math.max(
                                prices[i] + dp[1][k-1],
                                dp[0][k]
                        );
                    }
                    curr[j][k] = profit;
                }
            }
            dp = curr;
        }

        return dp[1][maxBuy];
    }

}
