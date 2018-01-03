class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 1;
        //预处理，将不可达点全部置为1
        //特殊情况，如果边界上有1
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            if(grid[i][0] == 1) {
                for(int j = i+1;j < m;j++) grid[j][0] = 1;
                break;
            }
            dp[i][0] = 1;
        }
        for(int i = 0;i < n;i++) {
            if(grid[0][i] == 1) {
                for(int j = i+1;j < n;j++) grid[0][j] = 1;
                break;
            }
            dp[0][i] = 1;
        }
        
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                if(grid[i][j] == 1) continue;
                if(grid[i-1][j] == 1 && grid[i][j-1] == 1) {
                    grid[i][j] = 1;
                } else if(grid[i-1][j] == 1 && grid[i][j-1] != 1) {
                    dp[i][j] = dp[i][j-1];
                } else if(grid[i-1][j] != 1 && grid[i][j-1] == 1) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
