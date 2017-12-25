class Solution {
	public boolean search(int[] nums,int target) {
        if(nums.length == 0) return false;
        // if(nums.length == 1) return nums[0] == target
		int lo = 0,hi = nums.length - 1,mid,highest = 0;
        int left,right;
        if(nums[lo] < nums[hi]) highest = hi;
        else {
            while(lo < hi) {
                if(hi - lo <= 1) {
                    if(nums[hi] >= nums[lo]) highest = hi;
                    else highest = lo;
                    break;
                }
                mid = (lo + hi) / 2;
                left = mid;
                right = mid;
                while(left >= lo+1 && nums[mid] == nums[left]) left--;
                while(right <= hi-1 && nums[mid] == nums[right]) right++;
                if(nums[mid] > nums[right]) {
                    highest = right - 1;
                    break;
                }
                if(nums[left] > nums[mid]) {
                    highest = left;
                    break;
                }
                
                if(nums[left] == nums[right]) {
                    highest = right;
                    break;
                }
                
                if(nums[left] < nums[mid] && nums[mid] < nums[right]) {
                    if(nums[left] < nums[hi]) hi = left;
                    if(nums[right] > nums[lo]) lo = right;
                } else if(nums[left] == nums[mid] && nums[mid] < nums[right]) {
                    lo = right;
                } else if(nums[left] < nums[mid] && nums[mid] == nums[right]) {
                    if(nums[right] > nums[lo]) highest = right;
                    else hi = left;
                } 
            }
        }

        
        //二分法查找，已知最高项角标为highest
        if(nums[0] <= target) {
            lo = 0;
            hi = highest;
        } else {
            lo = (highest + 1)%nums.length;
            hi = nums.length - 1;
        }
        while(lo < hi) {
            mid = (lo + hi)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return nums[lo] == target;     
	}
}

