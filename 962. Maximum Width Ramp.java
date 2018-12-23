class Solution {
    public int maxWidthRamp(int[] A) {
        int[] minIndex = new int[50001];
        int[] maxIndex = new int[50001];
        int ans = 0;
        Arrays.fill(minIndex,50001);
        Arrays.fill(maxIndex,-1);
        for (int i = 0; i < A.length; i++) {
            minIndex[A[i]] = Math.min(minIndex[A[i]],i);
            maxIndex[A[i]] = Math.max(maxIndex[A[i]],i);
        }
        int mi = minIndex[0];
        for (int i = 0; i < minIndex.length; i++) {
            if (minIndex[i] == 50001) continue;
            minIndex[i] = Math.min(mi,minIndex[i]);
            mi = minIndex[i];
        }
        for (int i = 0; i < minIndex.length; i++) {
            ans = Math.max(ans,maxIndex[i] - minIndex[i]);
        }
        return ans;
    }
}
