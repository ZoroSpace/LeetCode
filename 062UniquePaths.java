class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[m][n];
        for(int i = m - 1;i > -1;i--) {
            for(int j = n - 1;j > -1;j--) {
                if(i == m-1 || j == n-1) {
                    pathNum[i][j] = 1;
                } else {
                    pathNum[i][j] = pathNum[i][j+1] + pathNum[i+1][j];
                }
            }
        }
        return pathNum[0][0];
    }
}
