class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;
        if(n == 2) {
            int k = nums[0]+nums[1];
            nums[0] = k - nums[0];
            nums[1] = k - nums[1];
            return;
        }
        int i,j = 0;
        for(i = n-2;i > -1;i--) {
            for(j = n-1;j > i;j--) {
                if(nums[i] < nums[j]) {
                    int t = nums[i];
                    nums[i] =nums[j];
                    nums[j] = t;
                    Arrays.sort(nums,i+1,n);
                    return;
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
