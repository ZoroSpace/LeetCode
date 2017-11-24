class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<Integer> p = new LinkedList<Integer>();
        if(nums.length == 0) {
            result.add(p);
            return result;
        }
        if(nums.length == 1) {
            p.add(nums[0]);
            result.add(p);
            return result;
        }
        int[] sNums = new int[nums.length - 1];
        int lastNum = nums[nums.length - 1];
        System.arraycopy(nums,0,sNums,0,sNums.length);
        LinkedList<LinkedList<Integer>> sResult = (LinkedList)permute(sNums);
        for(LinkedList<Integer> list : sResult) {
            for(int i = 0;i < nums.length;i++) {
                p = (LinkedList<Integer>)list.clone();
                p.add(i,lastNum);
                result.add(p);
            }
        }
        return result;
    }
}
