class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        
        Arrays.sort(c);
        List<List<Integer>> result = helper(c,t,c.length);
        if(result == null) return new LinkedList<>();
        return result;
    }
    
    List<List<Integer>> helper(int[] nums, int sum, int length) {
        if(sum < 0 || (sum > 0 && length == 0)) return null;
        List<List<Integer>> result = new LinkedList<>();
        
        if(sum == 0) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        
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
