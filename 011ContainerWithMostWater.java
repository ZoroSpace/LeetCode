class Solution {
    public int maxArea(int[] nums) {
        if(nums.length <= 1) return 0;
        int result = 0;
        int[][] valid = new int[2][nums.length];
        valid[0][0] = 0;
        valid[1][0] = nums[0];
        int counter = 0;
        for(int i = 1;i < nums.length;i++) {
            for(int j = 0;j < counter+1;j++) {
                result = Math.max(result,(i-valid[0][j])*Math.min(nums[i],valid[1][j]));
            }
            if(nums[i] > valid[1][counter]) {
                counter++;
                valid[0][counter] = i;
                valid[1][counter] = nums[i];
            }
        }
        return result;
    }
}
