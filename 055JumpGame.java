class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int max = 0;
        for(int i = 1;i < n;i++) {
            max = Math.max(nums[i-1],max);
            for(int j = i-1;j > -1 && j > i-max-1;j--) {
                if(dp[j] && nums[j] >= i-j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
