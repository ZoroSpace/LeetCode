class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int n = nums.length;
        for(int i = n-1;i > 0;i--) {
            if(nums[i] < nums[i-1]) nums[i] = Math.min(1,nums[i]);
        }
        int[] step = new int[n];
        for(int i = 1;i < n;i++) step[i] = n;
        for(int i = 0;i < n;i++) {
            for(int j = 1;j <= nums[i] && i+j < n;j++) {
                step[i+j] = Math.min(step[i]+1,step[i+j]);
                if(step[n-1] < n) return step[i+j];
            }
        }
        return 0;
    }
}
