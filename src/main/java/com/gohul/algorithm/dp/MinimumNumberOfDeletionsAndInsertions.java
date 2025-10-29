package com.gohul.algorithm.dp;

public class MinimumNumberOfDeletionsAndInsertions {

    public static int canYouMake(String s, String t) {
        int lcs = memOpti(s.length(),t.length(),s,t);
        return (s.length()+t.length()) - (2*lcs);
    }
    public static int memOpti(int index1,int index2,String str1,String str2)
    {
        int[] dp=new int[index2+1];

        for(int i=1;i<index1+1;i++)
        {
            int[] curr=new int[index2+1];
            for(int j=1;j<index2+1;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1)) curr[j]=1+dp[j-1];
                else curr[j]=Math.max(dp[j],curr[j-1]);
            }
            dp=curr;
        }
        return dp[index2];
    }

}
