package com.gohul.algorithm.dp;

public class TargetSum {

    public static int targetSum(int n, int target, int[] arr) {
        int total=getTotal(arr);
        if(total-target<0||(total-target)%2!=0) return 0;
        //1
        // return findOut1(n-1,(total-target)/2,arr);
        //2
        return memOptimization(n,(total-target)/2,arr);

    }
    public static int getTotal(int[] arr)
    {
        int sum=0;
        for(int i:arr) sum+=i;
        return sum;
    }
    public static int findOut1(int index,int target,int[] num)
    {
        if(index==0)
        {
            if(target==0 && num[0]==0) return 2;
            if(target==0 || num[0]==target) return 1;
            return 0;
        }
        int notPick=findOut1(index-1,target,num);
        int pick=(target>=num[index])?findOut1(index-1,target-num[index],num):0;
        return (notPick+pick);
    }
    public static int memOptimization(int index, int target, int[] list)
    {
        int[] dp=new int[target+1];
        for(int i=0;i<=target;i++)
        {
            if(i==0 && list[0]==0) dp[i]=2;
            else if(i==0 || list[0]==i) dp[i]=1;
            else dp[i]=0;
        }
        for(int i=1;i<index;i++)
        {
            int[] curr=new int[target+1];
            for(int j=0;j<=target;j++)
            {
                int notPick=dp[j];
                int pick=(j>=list[i])?dp[j-list[i]]:0;
                curr[j]=(notPick+pick);
            }
            dp=curr;
        }
        return dp[target];
    }
}
