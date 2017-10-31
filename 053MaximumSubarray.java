class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int N = nums.length;
        int[] sums = new int[N+1];
        int[] mins = new int[N+1];
        sums[0] = 0;
        mins[0] = 0;
        
        int result1 = 0;
        int result2 = nums[0];
        for(int i = 0;i < N;i++) {
            sums[i+1] = sums[i] + nums[i];
            mins[i+1] = sums[i+1] < mins[i]?sums[i+1]:mins[i];
            result1 = result1 > sums[i+1] - mins[i+1]?result1:sums[i+1] - mins[i+1];
            if(result2 < nums[i]) result2 = nums[i];
        }
        if(result1 == 0) return result2;
        return result1 > result2?result1:result2;
    }
}
