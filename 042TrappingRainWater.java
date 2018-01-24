class Solution {
    public int trap(int[] nums) {
        int lo = 0,hi = nums.length-1,result = 0;
        while(lo < hi - 1) {
            if(nums[lo] < nums[hi]) {
                if(nums[lo]>=nums[lo+1]) {
                    result = result + nums[lo] - nums[lo+1];
                    nums[lo+1] = nums[lo];
                }
                lo++;
            } else {
                if(nums[hi] >= nums[hi-1]) {
                    result = result + nums[hi] - nums[hi-1];
                    nums[hi-1] = nums[hi];
                }
                hi--;
            }
        }
        return result;
    }
}
