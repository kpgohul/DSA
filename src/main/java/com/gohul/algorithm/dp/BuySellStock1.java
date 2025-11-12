package com.gohul.algorithm.dp;

import java.util.ArrayList;

public class BuySellStock1 {

    public static int maximumProfit(ArrayList<Integer> prices){
        int min = prices.get(0);
        int profit = 0;

        for(int i=1; i<prices.size(); i++){
            int currProfit = prices.get(i) - min;
            profit = Math.max(profit, currProfit);
            min = Math.min(min, prices.get(i));
        }

        return profit;
    }
}
