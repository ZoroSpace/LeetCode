class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length/3;
        int result = nums[nums.length - 1];
        for(int i = 0;i < length;i++) {
            result = (nums[3*i] ^ nums[3*i+1]) | (nums[3*i] ^ nums[3*i+2]) |(nums[3*i+2] ^ nums[3*i+1] |result ^ nums[3*i+1])|(nums[3*i+2] ^ result)|(nums[3*i+3] ^ result);
        }
        return result;
    }
}
