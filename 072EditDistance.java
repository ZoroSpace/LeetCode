class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(),n = s2.length();
        if(m == 0) return n;
        if(n == 0) return m;
        int[][] dp = new int[m][n];
        boolean flag = s1.charAt(0) == s2.charAt(0);
        if(flag) dp[0][0] = 0;
        else dp[0][0] = 1;
        
        for(int i = 1;i < n;i++) {
            if(!flag && s1.charAt(0) == s2.charAt(i)) {
                dp[0][i] = dp[0][i-1];
                flag = true;
            } else dp[0][i] = dp[0][i-1]+1;
        }
        flag = s1.charAt(0) == s2.charAt(0);
        for(int i = 1;i < m;i++) {
            if(!flag && s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = dp[i-1][0];
                flag = true;
            } else dp[i][0] = dp[i-1][0]+1;
        }
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) dp[i][j] = Math.min(dp[i-1][j-1]+(s1.charAt(i) == s2.charAt(j)?0:1),Math.min(dp[i][j-1]+1,dp[i-1][j]+1));
        }
        return dp[m-1][n-1];
    }
}
