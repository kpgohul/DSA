package com.gohul.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCoin {

    public static void main(String[] args) {

        int target = 11;
        System.out.println(MinimumCoins(target));

    }

    public static int MinimumCoins(int target){
//        int[] coins = {1,2,5,10,20,50,100,500,1000};
        int[] coins = {1, 5,6,9};
        // recursion
//        return findOut(coins.length -1, target, coins);

        //recurr - mem
//        int[][] dp = new int[coins.length][target + 1];
//        for(int[] t: dp) Arrays.fill(t, -1);
//        return findOut2(coins.length -1, target, coins, dp);

        //tabulation
//        return tabulation(coins.length, target, coins);

        //memory optimization
//        return memOptimal(coins.length, target, coins);

        //get the coin list
        List<Integer> res = findTheMinCoinList(coins.length, target, coins);
        System.out.println(res);
        return res.size();


    }

    private static int findOut(int index, int target, int[] coins) {

        if(index == 0){
            if(target % coins[0] == 0) return target/coins[0];
            else return Integer.MAX_VALUE;
        }

        int notTake = findOut(index-1, target, coins);
        int take = (coins[index] <= target)? 1 + findOut(index, target - coins[index], coins) : Integer.MAX_VALUE;

        return Math.min(notTake, take);
    }

    private static int findOut2(int index, int target, int[] coins, int[][] dp) {

        if(index == 0){
            if(target % coins[0] == 0) return target/coins[0];
            else return Integer.MAX_VALUE;
        }
        if(dp[index][target] != -1) return dp[index][target];

        int notTake = findOut2(index-1, target, coins, dp);
        int take = (coins[index] <= target)? 1 + findOut2(index, target - coins[index], coins, dp) : Integer.MAX_VALUE;

        return dp[index][target] = Math.min(notTake, take);
    }

    public static int tabulation(int n, int target, int[] coins){
        int[][] dp = new int[n][target + 1];
        for(int i=0; i<=target; i++){
            if(i%coins[0] == 0) dp[0][i] = i/coins[0];
            else dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=target; j++){
                int notTake = dp[i-1][j];
                int take = (j>=coins[i])? 1 + dp[i][j - coins[i]] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(notTake, take);
            }
        }
        for(int[] t: dp) System.out.println(Arrays.toString(t));

        return dp[coins.length - 1][target];
    }

    public static int memOptimal(int n, int target, int[] coins){
        int[] dp = new int[target + 1];
        for(int i=0; i<=target; i++){
            if(i%coins[0] == 0) dp[i] = i/coins[0];
            else dp[i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[target + 1];
            for(int j=0; j<=target; j++){
                int notTake = dp[j];
                int take = (j>=coins[i])? 1 + curr[j - coins[i]] : Integer.MAX_VALUE;
                curr[j] = Math.min(notTake, take);
            }
            dp = curr;
        }

        return dp[target];
    }

    public static List<Integer> findTheMinCoinList(int n, int target, int[] coins){
        int[][] dp = new int[n][target + 1];
        for(int i=0; i<=target; i++){
            if(i%coins[0] == 0) dp[0][i] = i/coins[0];
            else dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=target; j++){
                int notTake = dp[i-1][j];
                int take = (j>=coins[i])? 1 + dp[i][j - coins[i]] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(notTake, take);
            }
        }

        List<Integer> result = new ArrayList<>();

        int i = n -1;
        int j = target;

        while (i>=0 && j>=0){
            int currentCoin = coins[i];
            int top = (i > 0)? dp[i-1][j]: Integer.MAX_VALUE;
            int left = (j >= currentCoin)? dp[i][j - currentCoin]: Integer.MAX_VALUE;
            if(top > left) {
                result.add(currentCoin);
                j-=currentCoin;
            }
            else i-=1;
        }
        return result;
    }


}
