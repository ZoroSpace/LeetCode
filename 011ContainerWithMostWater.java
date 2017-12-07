class Solution {
    public int maxArea(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while(left < right) {
            if(nums[left] < nums[right]) {
                result = Math.max(result,nums[left] * (right - left));
                left++;
            } else {
                result = Math.max(result,nums[right] * (right - left));
                right--;
            }
        }
        return result;
    }
}
