class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums.length == 0) return 0;
        if(nums[hi] < target) return nums.length;
        return helper(nums,lo,hi,target);
    }
    
    int helper(int[] nums,int lo,int hi,int tar) {
        if(lo == hi && tar < nums[lo]) return lo;
        if(lo == hi && tar > nums[hi]) return hi;
        if(tar == nums[(lo + hi)/2]) return (lo + hi)/2;
        else if(tar < nums[(lo + hi)/2]) return helper(nums,lo,(lo + hi)/2,tar);
        else return helper(nums,(lo + hi)/2+1,hi,tar);
    }
}
