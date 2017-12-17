class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length;
        if(m == 0) return false;
        int n = mat[0].length;
        if(n == 0) return false;
        int mid;
        int lo = 0,hi = m*n-1;
        while(lo < hi) {
            mid = (hi+lo)/2;
            if(mat[mid/n][mid%n] < target) lo = mid+1;
            else hi = mid;
        }
        return mat[lo/n][lo%n]==target;
    }
}
