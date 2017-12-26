class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> origin = new ArrayList<>(n);
        for(int i = 0;i < n;i++) {
            origin.add(i,2123453647);
        }
        result.add(origin);
        int index = 0;
        while(index < n) {
            counter = 1;
            while((index+counter) < n && nums[index] == nums[index+counter]) counter++;
            for(List l : result) {
                //
                
            }
            index = index + counter;
        }
        
        
        return result;
    }
}
