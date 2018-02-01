class Solution {
    public int maxProfit(int[] nums) {
        if(nums.length <= 1) return 0;
		int min = nums[0],result = 0;
		int lo = 0,hi = 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int[] delta = new int[3];
		for(int i = 1;i < nums.length;i++) {
			if(nums[i] - min > result) {
				result = nums[i] - min;
				hi = i;
			}
			if(nums[i] < min) {
                dp[i] = i;
				lo = i;
				min = nums[i];
			} else dp[i] = dp[i-1];
		}
        lo = dp[hi];
		min = nums[0];
		for(int i = 0;i < lo;i++) {
			if(nums[i] - min > delta[0]) delta[0] = nums[i] - min;
			if(nums[i] < min) min = nums[i];
		}
        
        if(lo+1<nums.length) min = nums[lo+1];
		for(int i = lo+1;i < hi;i++) {
			if(min - nums[i] > delta[1]) delta[1] = min - nums[i];
			if(nums[i] > min) min = nums[i];
		}
        
        if(hi+1<nums.length) min = nums[hi+1];
		for(int i = hi+1;i < nums.length;i++) {
			if(nums[i] - min > delta[2]) delta[2] = nums[i] - min;
			if(nums[i] < min) min = nums[i];
		}
		Arrays.sort(delta);
		return result + delta[2];
    }
}
