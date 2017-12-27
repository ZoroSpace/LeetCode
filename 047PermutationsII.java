class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //提示：交换
        Arrays.sort(nums);
        return helper(nums,nums.length-1);
    }
    
    List<List<Integer>> helper(int[] nums,int index) {
        List<List<Integer>> newResult = new ArrayList<>();
        ArrayList<Integer> list2;
        if(nums.length == 0) {
            list2 = new ArrayList<>();
            newResult.add(list2);
            return newResult;
        }
        int t;
        if(index == 0) {
            list2 = new ArrayList<>();
            for(int i = 0;i < nums.length;i++) {
                list2.add(nums[0]);
            }
            newResult.add(list2);
            return newResult;
        }
        List<List<Integer>> result = helper(nums,index - 1);
        for(List<Integer> l : result) {
            ArrayList<Integer> list = (ArrayList<Integer>)((ArrayList<Integer>)l).clone();
            list.set(index,nums[index]);
            for(int i = 0;i < index;i++) {
                list2 = (ArrayList<Integer>)list.clone();
                if(nums[index] == list2.get(i)) break;//break 神来之笔
                t = list2.get(i);
                list2.set(i,list2.get(index));
                list2.set(index,t);
                newResult.add(list2);
            }
            newResult.add(list);
        }
        return newResult;
    }
}
