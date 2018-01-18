class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int lo,hi;
        List<Integer> cur;
        for(int i = 0;i < nums.length - 1;) {
            lo = i+1;
            hi = nums.length - 1;
            while(lo < hi) {
                if(nums[lo] + nums[hi] + nums[i] == 0) {
                    cur = new LinkedList<>();
                    cur.add(nums[lo]);
                    cur.add(nums[hi]);
                    cur.add(nums[i]);
                    result.add(cur);
                    lo++;
                    while(lo < hi && nums[lo] == nums[lo-1]) lo++;
                    hi--;
                    while(lo < hi && nums[hi] == nums[hi+1]) hi--;
                } else if(nums[lo] + nums[hi] + nums[i] < 0) lo++;
                else hi--;
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return result;
    }
}
