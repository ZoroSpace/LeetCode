class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int n = nums.length;
        for(int i = 0;i < n;i++) {
            if(nums[i] < 0) nums[i] = 0;
            if(nums[i] > n) nums[i] = n+1;
        }
        boolean[] flags = new boolean[n+2];
        for(int i = 0;i < n;i++) {
            flags[nums[i]] = true;
        }
        for(int i = 1;i < n+2;i++) {
            if(!flags[i]) return i;
        }
        return 0;
    }
}
