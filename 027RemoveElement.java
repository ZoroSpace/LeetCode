class Solution {
    public int removeElement(int[] nums, int val) {
        int lo = 0;
        int hi = nums.length - 1;
        int t;
        while(lo <= hi) {
            while(nums[hi] == val) {
                hi--;
                if(hi < lo) return lo;
            }
            if(nums[lo] == val) {
                t = nums[hi];
                nums[hi] = nums[lo];
                nums[lo] = t;
                lo++;
            } else {
                lo++;
            }
        }
        return lo;
    }
}
