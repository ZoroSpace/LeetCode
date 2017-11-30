class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0) return result;
        if(n == 1) {
            result[0][0] = 1;
            return result;
        }
        if(n == 2) {
            result[0][0] = 1;
            result[0][1] = 2;
            result[1][1] = 3;
            result[1][0] = 4;
            return result;
        }
        for(int i = 0;i < n-1;i++) {
            result[0][i] = i+1;
            result[i][n-1] = i+n;
            result[n-1][n-1-i] = i+2*n-1;
            result[n-1-i][0] = i+3*n-2;
        }
        int[][] small = generateMatrix(n-2);
        int delta = 4*n-4;
        for(int i = 0;i < n-2;i++) {
            for(int j = 0;j < n-2;j++) {
                result[i+1][j+1] = small[i][j]+delta;
            }
        }
        return result;
    }
}
