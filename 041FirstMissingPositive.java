class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int n = nums.length;
        boolean[] flags = new boolean[n];
        for(int i = 0;i < n;i++) {
            if(nums[i] >= 1 && nums[i] <= n) flags[nums[i]-1] = true;
        }
        for(int i = 0;i < n;i++) {
            if(!flags[i]) return i+1;
        }
        return n+1;
    }
}


class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length,t;
        for(int i = 0;i < n;i++) {
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                t = nums[i];
                nums[i] = nums[t-1];
                nums[t-1] = t;
            }
        }
        for(int i = 0;i < n;i++) {
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }
    
}
