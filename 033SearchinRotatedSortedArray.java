class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int lo = 0, hi = nums.length-1;
        int mid;
        while(lo < hi-1) {
            mid = (lo+hi)/2;
            if(nums[0] > nums[mid]) hi = mid;
            if(nums[mid] > nums[0]) lo = mid;
        }
        int highest = (nums[lo] > nums[hi])?lo:hi;
        if(nums[0] <= target) {
            lo = 0;
            hi = highest;
        } else {
            lo = (highest+1) % nums.length;
            hi = nums.length-1;
        }
        
        while(lo < hi) {
            mid = (lo+hi)/2;
            if(nums[mid] < target) lo = mid+1;
            else if(nums[mid] > target) hi = mid;
            else return mid;
        }
        if(nums[lo]==target) return lo;
        else return -1;
    }
}
