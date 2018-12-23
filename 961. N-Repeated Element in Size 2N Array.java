class Solution {
    public int repeatedNTimes(int[] A) {
        if(A[0] == A[2] || A[0] == A[3]) return A[0];
        if(A[1] == A[3]) return A[1];
        for(int i = 1;i < A.length;i++) {
            if(A[i] == A[i-1]) return A[i];
        }
        return 0;
    }
}
