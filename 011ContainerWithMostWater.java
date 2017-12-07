class Solution {
    public int maxArea(int[] nums) {
        if(nums.length <= 1) return 0;
        int left = 0;
        int right = 1;
        int result = 0;
        for(int i = 1;i < nums.length;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] != 0 ) {
                    result = Math.max(result,(i-j)*Math.min(nums[i],nums[j]));
                }
            }
            if(nums[i] <= nums[left]) nums[i] = 0;
            else {
                left = i;
            }
        }
        return result;
    }
}
