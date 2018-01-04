class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        result[0] = -1;
        result[1] = -1;
        
        int lo = 0,hi = nums.length-1,mid = 0;
        if(nums[lo] > target || nums[hi] < target) return result;
        
        while(lo <= hi && !flag) {
            mid = (lo+hi) / 2;
            if(nums[mid] < target) lo = mid+1;
            else if(nums[mid] > target) hi = mid-1;
            else if(nums[mid] == target) flag = true;
        }
        if(!flag) return result;
        int start = mid;
        int left = 0,right = nums.length - 1;
        int mid1 = 0,mid2 = nums.length - 1;
        while(!(nums[mid1] == target && (mid1 == 0 || nums[mid1-1] != target))) {
            mid1 = (left+mid)/2;
            if(nums[mid1] < target) left = mid1+1;
            else mid = mid1;
        }
        while(!(nums[mid2] == target && (mid1 == nums.length - 1 || nums[mid1+1] != target))) {
            mid1 = (start+right)/2;
            if(nums[mid2] > target) right = mid1-1;
            else start = mid1;
        }
        result[0] = mid1;
        result[1] = mid2;
        return result;
    }
}
