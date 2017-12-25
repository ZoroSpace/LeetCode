class Solution {
	public boolean search(int[] nums,int target) {
        if(nums.length == 0) return false;
        // if(nums.length == 1) return nums[0] == target
		int lo = 0,hi = nums.length - 1,mid,highest;
        if(nums[lo] < nums[hi]) highest = hi;
        else {
            while(lo < hi) {
                mid = (lo + hi) / 2;
                if(nums[lo] >= nums[mid]) hi = mid;
                else lo = mid+1;
            }
            highest = lo;
            if(highest+1 < nums.length && nums[highest] < nums[highest+1]) highest++;
            if(highest >0 && nums[highest] < nums[highest-1]) highest--;
        }
        return highest == 4;
        
        // //二分法查找，已知最高项角标为highest
        // if(nums[0] <= target) {
        //     lo = 0;
        //     hi = highest;
        // } else {
        //     lo = (highest + 1)%nums.length;
        //     hi = nums.length - 1;
        // }
        // while(lo < hi) {
        //     mid = (lo + hi)/2;
        //     if(nums[mid] == target) return true;
        //     else if(nums[mid] > target) hi = mid - 1;
        //     else lo = mid + 1;
        // }
        // return nums[lo] == target;     
	}
}

