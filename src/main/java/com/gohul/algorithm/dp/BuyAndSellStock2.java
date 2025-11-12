package com.gohul.algorithm.dp;

public class BuyAndSellStock2 {

    public static long getMaximumProfit (int n, long[] values) {

        //recurr
        // return findOut(0, 1, values);

        // recurr + dp
        // long[][] dp = new long[n][2];
        // for(long[] t: dp) Arrays.fill(t, -1l);
        // return findOut(0, 1, values, dp);

        //tabulation
        // return tabulation(n, values);

        //memOpti
        return memopti(n, values);

    }

    public static long findOut(int index, int canBuy, long[] values){
        if(index == values.length) return 0;

        long profit = 0;

        if(canBuy == 1){
            profit = Math.max(findOut(index + 1, 0, values) - values[index], findOut(index + 1, 1, values));
        }
        else{
            profit = Math.max(values[index] + findOut(index + 1, 1, values), findOut(index + 1, 0, values));
        }

        return profit;
    }

    public static long findOut(int index, int canBuy, long[] values, long[][] dp){
        if(index == values.length) return 0;
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        long profit = 0;

        if(canBuy == 1){
            profit = Math.max(findOut(index + 1, 0, values, dp) - values[index], findOut(index + 1, 1, values, dp));
        }
        else{
            profit = Math.max(values[index] + findOut(index + 1, 1, values, dp), findOut(index + 1, 0, values, dp));
        }

        return dp[index][canBuy] = profit;
    }

    public static long tabulation(int n, long[] values){
        long[][] dp = new long[n + 1][2];

        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                long profit = 0;
                if(j==1)
                    profit = Math.max(dp[i + 1][0] - values[i], dp[i + 1][1]);
                else
                    profit = Math.max(values[i] + dp[i + 1][1], dp[i + 1][0]);
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }

    public static long memopti(int n, long[] values){
        long[] dp = new long[2];

        for(int i = n-1; i>=0; i--){
            long[] curr = new long[2];
            for(int j=0; j<=1; j++){
                long profit = 0;
                if(j==1)
                    profit = Math.max(dp[0] - values[i], dp[1]);
                else
                    profit = Math.max(values[i] + dp[1], dp[0]);
                curr[j] = profit;
            }
            dp = curr;
        }

        return dp[1];
    }

}
