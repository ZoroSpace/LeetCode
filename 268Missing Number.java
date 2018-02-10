class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] == 0) return 1;
        if(nums.length % 2 == 1) return helper1(nums);
        else return helper2(nums);
    }
    
    int helper1(int[] nums) {
        int n = nums.length;
        int result = nums[0]>>1;
        for(int i = 1;i < n;i++) {
            result = (nums[i]>>1)^(result);
        }
        result = result<<1;

        for(int i = 0;i < n;i++) {
            if(result == nums[i]) return nums[i]+1;
        }
        return result;
    }
    
    int helper2(int[] nums) {
        int n = nums.length;
        int result = (nums[0]+1)>>1;
        for(int i = 1;i < n;i++) {
            result = ((nums[i]+1)>>1)^(result);
        }
        result = result<<1;

        for(int i = 0;i < n;i++) {
            if(result == nums[i]) return nums[i]-1;
        }
        return result;
    }
}
