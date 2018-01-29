class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() == 0) return 1;
        if(s.length() < t.length()) return 0;
        int m = t.length(),n = s.length();
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < i;j++) dp[i][j] = 0;
        }
        dp[0][0] = s.charAt(0) == t.charAt(0)?1:0;
        for(int i = 1;i < n;i++) {
            dp[0][i] = dp[0][i-1] + (s.charAt(i) == t.charAt(0)? 1:0);
        }
        for(int i = 1;i < m;i++) {
            for(int j = i;j < n;j++) {
                dp[i][j] = dp[i][j-1] + (s.charAt(j) == t.charAt(i)?dp[i-1][j-1]:0);
            }
        }
        return dp[m-1][n-1];
    }
}
