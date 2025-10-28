package com.gohul.algorithm.dp;

public class LongestCommonSubstring {

    public static void main(String[] args) {

    }

    public static int tabulation(String str1, String str2){

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static int memOpti(String str1,String str2)
    {
        int n1=str1.length();
        int n2=str2.length();
        int[] dp=new int[n2+1];
        int max=0;
        for(int i=1;i<n1+1;i++)
        {
            int[] curr=new int[n2+1];
            for(int j=1;j<n2+1;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    curr[j]=1+dp[j-1];
                    max=Math.max(curr[j],max);
                }

            }dp=curr;
        }
        return max;
    }
}
