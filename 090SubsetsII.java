class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> oldResult = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        oldResult.add(list);
        Arrays.sort(nums);
        int i = 0,j = 0;
        List l1;
        while(j < nums.length) {
            while(j < nums.length && nums[i] == nums[j++]);
            for(List l : oldResult) {
                for(int k = 0;k < j-i+1;k++){
                    l1 = (LinkedList)((LinkedList)l).clone();
                    for(int m = 0;m < k;m++) {
                        l1.add(nums[i]);
                    }
                    result.add(l1);
                }
            }
            oldResult = result;
            i = j;
        }
        return result;
    }
}
