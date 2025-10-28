package com.gohul.algorithm.dp;

public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubsequence(String s) {
        // int[][] dp=new int[s.length()+1][s.length()+1];
        // for(int[] t:dp) Arrays.fill(t,-1);
        // return findOut2(s.length()-1,s.length()-1,s,new StringBuilder(s).reverse().toString(),dp);
        //
        // return tabulation(s.length(),s.length(),s,new StringBuilder(s).reverse().toString());
        return memOpti(s.length(),s.length(),s,new StringBuilder(s).reverse().toString());
    }
    public static int findOut1(int index1,int index2,String str1,String str2)
    {
        if(index1<0 || index2<0) return 0;
        if(str1.charAt(index1)==str2.charAt(index2))
            return 1+findOut1(index1-1,index2-1,str1,str2);
        else return Math.max(findOut1(index1-1,index2,str1,str2),findOut1(index1,index2-1,str1,str2));
    }
    public static int findOut2(int index1,int index2,String str1,String str2,int[][] dp)
    {
        if(index1<0 || index2<0) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(str1.charAt(index1)==str2.charAt(index2))
            return 1+findOut2(index1-1,index2-1,str1,str2,dp);
        else return Math.max(findOut2(index1-1,index2,str1,str2,dp),findOut2(index1,index2-1,str1,str2,dp));
    }
    public static int tabulation(int index1,int index2,String str1,String str2)
    {
        int[][] dp=new int[index1+1][index2+1];
        for(int i=1;i<=index1;i++)
        {
            for(int j=1;j<=index2;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[index1][index2];
    }
    public static int memOpti(int index1,int index2,String str1,String str2)
    {
        int[] dp=new int[index2+1];
        for(int i=1;i<=index1;i++)
        {
            int[] curr=new int[index2+1];
            for(int j=1;j<=index2;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1)) curr[j]=1+dp[j-1];
                else curr[j]=Math.max(dp[j],curr[j-1]);
            }
            dp=curr;
        }
        return dp[index2];
    }

}
