class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i < n+1;i++) dp[m][i] = Integer.MAX_VALUE;
        for(int i = 0;i < m+1;i++) dp[i][n] = Integer.MAX_VALUE;
        dp[m][n-1] = 0;
        for(int i = m-1;i > -1;i--) {
            for(int j = n-1;j > -1;j--) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
