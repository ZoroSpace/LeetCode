class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length < 4) return result;
        Arrays.sort(nums);
        int lo,hi,delta;
        List<Integer> list;
        for(int i = 0;i < nums.length - 3;) {
            for(int j = i+1;j < nums.length - 2;) {
                lo = j+1;
                hi = nums.length - 1;
                delta = target - nums[i] - nums[j];
                while(lo < hi) {
                    if(nums[lo] + nums[hi] < delta) lo++;
                    else if(nums[lo] + nums[hi] > delta) hi--;
                    else {
                        list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[lo]);
                        list.add(nums[hi]);
                        result.add(list);
                        lo++;
                        while(lo < hi && nums[lo] == nums[lo-1]) lo++;
                    }
                }
                j++;
                while(j < nums.length - 2 && nums[j] == nums[j-1]) j++;
            }
            i++;
            while(i < nums.length - 3 && nums[i] == nums[i-1]) i++;
        }
        return result;
    }
}
