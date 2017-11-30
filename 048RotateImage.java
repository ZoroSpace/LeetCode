class Solution {
    public void rotate(int[][] a) {
        int n = a.length;
        int t1,t2,t3,t4;
        for(int i = 0;i < (n+1)/2;i++) {
            for(int j = 0;j < n/2;j++) {
                t1 = a[i][j];
                t2 = a[j][n-1-i];
                t3 = a[n-1-i][n-1-j];
                t4 = a[n-1-j][i];
                a[i][j] = t4;
                a[j][n-1-i] = t1;
                a[n-1-i][n-1-j] = t2;
                a[n-1-j][i] = t3;
            }
        }
    }
}
