class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(c);
        return helper(c,t,c.length);
    }
    
    List<List<Integer>> helper(int[] nums, int sum, int length) {
        if(sum < 0 || (sum > 0 && length == 0)) return null;
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());
        if(sum == 0) return result;
        
        
        while(length > 0 && nums[length-1] > sum) length--;
        if(length == 0) return null;
        
        int counter = 1;
        while(length - 1 - counter >= 0 && nums[length - 1] == nums[length - 1 - counter]) counter++;
        
        for(int i = 0;i <= counter;i++) {
            List<List<Integer>> deeper = helper(nums,sum-i*nums[length-1],length - counter);
            if(deeper != null) {
                for(List<Integer> l : deeper) {
                    for(int j = 0;j < i;j++) {
                        l.add(nums[length-1]);
                    }
                    result.add(l);
                }
            }
        }
        return result;
    }
}
