class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int c1 = 0,c2 = 1,counter = 1;
        while(c2 < nums.length) {
            if(counter == 2) {
                if(nums[c1] != nums[c2]) {
                    c1++;
                    nums[c1] = nums[c2];
                    counter = 1;
                }
                    c2++;
            } else {
                if(nums[c1] == nums[c2]) {
                    c1++;
                    nums[c1] = nums[c2];
                    counter = 2;
                    c2++;
                } else {
                    c1++;
                    nums[c1] = nums[c2];
                    c2++;
                }
            }
        }
        return c1+1;
    }
}
