package com.gohul.algorithm.dp;

public class BuyAndSellWithCoolDown {

    public static int stockProfit(int[] prices) {

        // recurr
        // return findOut(0, 1, prices);

        // recurr + dp
        // int[][] dp = new int[prices.length][2];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return findOut(0, 1, prices, dp);

        return tabulation(prices.length, prices);
    }

    public static int findOut(int index, int canBuy, int[] prices){
        if(index >= prices.length) return 0;

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(
                    -prices[index] + findOut(index + 1, 0, prices),
                    findOut(index + 1, 1, prices)
            );
        }
        else{
            profit = Math.max(
                    prices[index] + findOut(index + 2, 1, prices),
                    findOut(index + 1, 0, prices)
            );
        }

        return profit;
    }

    public static int findOut(int index, int canBuy, int[] prices, int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(
                    -prices[index] + findOut(index + 1, 0, prices, dp),
                    findOut(index + 1, 1, prices, dp)
            );
        }
        else{
            profit = Math.max(
                    prices[index] + findOut(index + 2, 1, prices, dp),
                    findOut(index + 1, 0, prices, dp)
            );
        }

        return dp[index][canBuy] = profit;
    }

    public static int tabulation(int n, int[] prices){
        int[][] dp = new int[n+2][2];

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                int profit = 0;
                if(j==1){
                    profit = Math.max(
                            -prices[i] + dp[i+1][0],
                            dp[i+1][1]
                    );
                }
                else{
                    profit = Math.max(
                            prices[i] + dp[i+2][1],
                            dp[i+1][0]
                    );
                }
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }
}
