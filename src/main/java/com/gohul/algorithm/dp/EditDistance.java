package com.gohul.algorithm.dp;

public class EditDistance {

    public static int editDistance(String str1, String str2) {
        //recurr
        // return findOut(str1.length() - 1, str2.length() - 1, str1, str2);
        // int[][] dp = new int[str1.length()][str2.length()];
        // for(int[] t: dp) Arrays.fill(t, -1);
        // return findOut2(str1.length() - 1, str2.length() - 1, str1, str2, dp);
        // return tabulation(str1.length(), str2.length(), str1, str2);
        // return memOpti(str1.length(), str2.length(), str1, str2);
        return singleArrayOpti(str1.length(), str2.length(), str1, str2);

    }

    public static int findOut(int i, int j, String str1, String str2){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(str1.charAt(i) == str2.charAt(j)) return findOut(i-1, j-1, str1, str2);
        return 1 +Math.min(
                findOut(i, j-1, str1, str2),
                Math.min(
                        findOut(i-1, j, str1, str2),
                        findOut(i-1, j-1, str1, str2)
                )
        );
    }

    public static int findOut2(int i, int j, String str1, String str2, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)) return dp[i][j] = findOut2(i-1, j-1, str1, str2, dp);
        return dp[i][j] = 1 +Math.min(
                findOut2(i, j-1, str1, str2, dp),
                Math.min(
                        findOut2(i-1, j, str1, str2, dp),
                        findOut2(i-1, j-1, str1, str2, dp)
                )
        );
    }

    public static int tabulation(int n1, int n2, String str1, String str2){

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n2; i++) dp[0][i] = i;
        for (int i = 0; i <= n1; i++) dp[i][0] = i;

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(
                        dp[i][j-1],
                        Math.min(
                                dp[i-1][j-1],
                                dp[i-1][j]
                        )
                );
            }
        }
        return dp[n1][n2];
    }

    public static int memOpti(int n1, int n2, String str1, String str2){

        int[] dp = new int[n2 + 1];
        for (int i = 0; i <= n2; i++) dp[i] = i;

        for(int i=1; i<=n1; i++){
            int[] curr = new int[n2 + 1];
            curr[0] = i;
            for(int j=1; j<=n2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) curr[j] = dp[j-1];
                else curr[j] = 1 + Math.min(
                        curr[j-1],
                        Math.min(
                                dp[j-1],
                                dp[j]
                        )
                );
            }
            dp = curr;
        }
        return dp[n2];
    }

    public static int singleArrayOpti(int n1, int n2, String str1, String str2) {
        int[] dp = new int[n2 + 1];

        for (int j = 0; j <= n2; j++) dp[j] = j;

        for (int i = 1; i <= n1; i++) {
            int prevDiagonal = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n2; j++) {
                int temp = dp[j];

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = prevDiagonal;
                } else {
                    dp[j] = 1 + Math.min(
                            prevDiagonal,
                            Math.min(dp[j], dp[j - 1])
                    );
                }

                prevDiagonal = temp;
            }
        }

        return dp[n2];
    }
}
