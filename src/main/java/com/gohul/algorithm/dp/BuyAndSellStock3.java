package com.gohul.algorithm.dp;

public class BuyAndSellStock3 {

    public static int maxProfit(int[] prices) {

        int max = 2;

        //recurr
        // return findOut(0, prices, 1, max);


        //recurr + dp
        // int[][][] dp = new int[prices.length][2][max + 1];
        // for(int[][] tt: dp) for(int[] t: tt) Arrays.fill(t, -1);
        // return findOut(0, prices, 1, max, dp);

        //tabulation
        // return tabulation(prices.length, prices, max);

        //memOpti
        return memOpti(prices.length, prices, max);

    }

    public static int findOut(int index, int[] prices, int canBuy, int max){
        if(max == 0 || index == prices.length) return 0;
        int profit = 0;
        if(canBuy == 1){
            profit = Math.max(
                    -prices[index] + findOut(index + 1, prices, 0, max),
                    findOut(index + 1, prices, 1, max)
            );
        }
        else{
            profit = Math.max(
                    prices[index] + findOut(index + 1, prices, 1, max - 1),
                    findOut(index + 1, prices, 0, max)
            );
        }

        return profit;
    }

    public static int findOut(int index, int[] prices, int canBuy, int max, int[][][] dp){
        if(max == 0 || index == prices.length) return 0;
        if(dp[index][canBuy][max] != -1) return dp[index][canBuy][max];
        int profit = 0;
        if(canBuy == 1){
            profit = Math.max(
                    -prices[index] + findOut(index + 1, prices, 0, max),
                    findOut(index + 1, prices, 1, max)
            );
        }
        else{
            profit = Math.max(
                    prices[index] + findOut(index + 1, prices, 1, max - 1),
                    findOut(index + 1, prices, 0, max)
            );
        }

        return dp[index][canBuy][max] = profit;
    }

    public static int tabulation(int n, int[] prices, int max) {

        int[][][] dp = new int[n + 1][2][max + 1];


        for(int i=n-1;i>=0;i--){
            for(int j=0; j<=1; j++){
                for(int k=1; k<=max; k++){
                    if(j==1){
                        dp[i][j][k] = Math.max(
                                -prices[i] + dp[i + 1][0][k],
                                dp[i + 1][1][k]
                        );
                    }
                    else{
                        dp[i][j][k] = Math.max(
                                prices[i] + dp[i + 1][1][k - 1],
                                dp[i + 1][0][k]
                        );
                    }
                }
            }
        }

        return dp[0][1][max];
    }

    public static int memOpti(int n, int[] prices, int max) {

        int[][] dp = new int[2][max + 1];


        for(int i=n-1;i>=0;i--){

            int[][] curr = new int[2][max + 1];

            for(int j=0; j<=1; j++){
                for(int k=1; k<=max; k++){
                    if(j==1){
                        curr[j][k] = Math.max(
                                -prices[i] + dp[0][k],
                                dp[1][k]
                        );
                    }
                    else{
                        curr[j][k] = Math.max(
                                prices[i] + dp[1][k - 1],
                                dp[0][k]
                        );
                    }
                }
            }
            dp = curr;
        }

        return dp[1][max];
    }

}
