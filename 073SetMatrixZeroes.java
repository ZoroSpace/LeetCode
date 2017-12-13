class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        if(m == 0) return;
        int n = mat[0].length;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(mat[i][j] == 0) {
                    for(int k = 0;k < n;k++) { if(mat[i][k] != 2147483647 && mat[i][k] != 0) mat[i][k] = 2147483647;}
                    for(int k = 0;k < m;k++) { if(mat[k][j] != 2147483647 && mat[k][j] != 0) mat[k][j] = 2147483647;}
                }
            }
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(mat[i][j] == 2147483647) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
