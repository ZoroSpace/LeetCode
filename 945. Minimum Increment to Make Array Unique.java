class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A.length <= 1) return 0;
        Arrays.sort(A);
        int counter = 0;
        int start = 0,end = 0;
        int sum = 0;
        while (end < A.length) {
            if (A[end] - A[start] > end - start) {
                counter = counter + sum;
                start++;
                sum = 0;
            } else {
                sum += end - start - (A[end] - A[start]);
                end++;
            }
        }
        counter += sum;
        return counter;
    }
}
