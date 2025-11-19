package com.gohul.algorithm.dp;

public class BuyAndSellStockWithTransactionFee {

    public static int maximumProfit(int[] prices, int n, int fee) {

        // recurr
        // return findOut(0, 1, prices, fee);

        // recurr + dp
        // int[][] dp = new int[prices.length][2];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return findOut(0, 1, prices, fee, dp);

        //tabulation
        // return tabulation(prices.length, prices,  fee);

        //mem-opti
        return memOpti(prices.length, prices,  fee);

    }

    public static int findOut(int index, int canBuy, int[] prices, int fee){
        if(index >= prices.length) return 0;

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(
                    -prices[index] + findOut(index + 1, 0, prices, fee),
                    findOut(index + 1, 1, prices, fee)
            );
        }
        else{

            profit = Math.max(
                    prices[index] - fee + findOut(index + 1, 1, prices, fee),
                    findOut(index + 1, 0, prices, fee)
            );
        }

        return profit;
    }

    public static int findOut(int index, int canBuy, int[] prices, int fee, int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][canBuy] != -1) return dp[index][canBuy];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(
                    -prices[index] + findOut(index + 1, 0, prices, fee, dp),
                    findOut(index + 1, 1, prices, fee, dp)
            );
        }
        else{

            profit = Math.max(
                    prices[index] - fee + findOut(index + 1, 1, prices, fee, dp),
                    findOut(index + 1, 0, prices, fee, dp)
            );
        }

        return dp[index][canBuy] = profit;
    }

    public static int tabulation(int n, int[] prices, int fee){

        int[][] dp = new int[n + 1][2];

        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j==1){
                    dp[i][j] = Math.max(
                            -prices[i] + dp[i + 1][0],
                            dp[i+1][1]
                    );
                }
                else{
                    dp[i][j] = Math.max(
                            prices[i] - fee + dp[i+1][1],
                            dp[i+1][0]
                    );
                }
            }
        }
        return dp[0][1];
    }

    public static int memOpti(int n, int[] prices, int fee){

        int[] dp = new int[2];

        for(int i = n-1; i>=0; i--){
            int[] curr = new int[2];
            for(int j=0; j<=1; j++){
                if(j==1){
                    curr[j] = Math.max(
                            -prices[i] + dp[0],
                            dp[1]
                    );
                }
                else{
                    curr[j] = Math.max(
                            prices[i] - fee + dp[1],
                            dp[0]
                    );
                }
            }
            dp = curr;
        }
        return dp[1];
    }

}
