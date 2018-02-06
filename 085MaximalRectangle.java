public class Solution {
	public int maximalRectangle(char[][] matrix) {
        
		if(matrix.length == 0|| matrix[0].length == 0) return 0;
		int m = matrix.length,n = matrix[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = matrix[0][0] - '0';
		for(int i = 1;i < m;i++) {
			dp[i][0] = matrix[i][0] == '0'? 0:dp[i-1][0]+1;
		}
		for(int i = 1;i < n;i++) {
			dp[0][i] = matrix[0][i] == '0'?0:dp[0][i-1]+1;
		}
		for(int i = 1;i < m;i++) {
			for(int j = 1;j < n;j++) {
				if(matrix[i][j] == '0') dp[i][j] = 0;
				else if(matrix[i-1][j] == '0' && matrix[i][j-1] != '0') dp[i][j] = dp[i][j-1]+1;
                else if(matrix[i][j-1] == '0' && matrix[i-1][j] != '0') dp[i][j] = dp[i][j-1]+1;
                else if(matrix[i][j-1] == '0' && matrix[i-1][j] == '0') dp[i][j] = 1;
                else {
                    
                }
			}
		}
	}
}

