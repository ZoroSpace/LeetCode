class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int lo,mid,hi,delta;
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2;i++) {
            for(int j = i+1;j < nums.length - 1;j++) {
                lo = j + 1;
                hi = nums.length - 1;
                while(lo < hi - 1) {
                    mid = (lo + hi) / 2;
                    delta = target - nums[i] - nums[j] - nums[mid];
                    if(delta == 0) return 0;
                    else if(delta > 0) lo = mid;
                    else hi = mid;
                }
                if(Math.abs(target - nums[i] - nums[j] - nums[lo]) < Math.abs(target - result)) result = nums[i] + nums[j] + nums[lo];
                if(Math.abs(target - nums[i] - nums[j] - nums[hi]) < Math.abs(target - result)) result = nums[i] + nums[j] + nums[lo];
            }
        }
        return result;
    }
}
