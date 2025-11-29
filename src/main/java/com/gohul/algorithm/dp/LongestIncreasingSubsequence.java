package com.gohul.algorithm.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] list = {50, 3, 90, 60, 80};

//        int[][] dp = new int[list.length][list.length + 1];
//        for(int[] t: dp) Arrays.fill(t, -1);
//
//        System.out.println(findOut(0, -1, list, dp));
//
//        Arrays.stream(dp).forEach( t -> Arrays.stream(t).forEach(i -> ));

//        System.out.println(tabulation(list.length, list));

        System.out.println(printLIS(list.length, list));

    }

    public static int findOut(int index, int pre, int[] list){
        if(index == list.length) return 0;

        int notTake = findOut(index + 1, pre, list);
        int take = 0;
        if(pre == -1 || list[pre] < list[index])
            take = 1 + findOut(index + 1, index, list);

        return Math.max(notTake, take);
    }

    public static int findOut(int index, int pre, int[] list, int[][] dp){
        if(index == list.length) return 0;
        if(dp[index][pre + 1] != -1) return dp[index][pre];

        int notTake = findOut(index + 1, pre, list, dp);
        int take = 0;
        if(pre == -1 || list[pre] < list[index])
            take = 1 + findOut(index + 1, index, list, dp);

        return dp[index][pre + 1] = Math.max(notTake, take);
    }

    public static int tabulation(int n, int[] list) {

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int pre = i - 1; pre >= -1; pre--) {

                int notTake = dp[i + 1][pre + 1];

                int take = 0;
                if (pre == -1 || list[pre] < list[i]) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][pre + 1] = Math.max(notTake, take);
            }
        }

        Arrays.stream(dp).forEach(i-> System.out.println(Arrays.toString(i)));

        return dp[0][0];
    }

    public static int optimal(int n, int[] list){

        int[] dp = new int[list.length];
        int maxLen = 0;

        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(list[j] < list[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;

    }

    public static int optimalCount(int n, int[] list){

        int[] dp = new int[list.length];
        int[] count = new int[list.length];
        int maxLen = 0;

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(list[j] < list[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if(list[j] < list[i] && dp[j] + 1 == dp[i]){
                    count[i] += count[j];
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

       int res = 0;

        for(int i = 0; i < n; i++){
            if(dp[i] == maxLen) res += count[i];
        }

        return res;

    }

    public static String printLIS(int n, int[] list){
        int[] dp = new int[n];
        int[] hash = new int[n];

        int maxLen = 0;
        int lastIndex = -1;
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++){
            hash[i] = i;
            for(int j=0; j<i; j++){
                if(list[j] < list[i] && dp[j] + 1 > dp[i]){

                    dp[i] = dp[j] + 1;
                    hash[i] = j;

                }
            }
            if(maxLen < dp[i]){
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        String res = String.valueOf(list[lastIndex]);
        while (hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            res = list[lastIndex] + res;
        }

        return res;

    }


}
