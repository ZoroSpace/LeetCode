class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,target);
    }

    List<List<Integer>> helper(int[] c, int x) {
        List<List<Integer>> result = new LinkedList<>();
        int n = c.length;
        int i;
        for(i = n-1;i >= -1;i--) {
            if(i == -1) {
                return null;
            }
            if(c[i] <= x) break;
        }
        int[] subC = new int[i];
        System.arraycopy(c,0,subC,0,i);
        if(c[i] == x) {
            List<Integer> list = new LinkedList<>();
            list.add(x);
            result.add(list);
            if(helper(subC,x) != null) {
                for(List l1 : helper(subC,x)) {
                    result.add(l1);
                }
            } return result;
        } else {
            if(helper(subC,x) != null) {
                for(List l1 : helper(subC,x)) {
                    result.add(l1);
                }
            }
            if(helper(subC,x-c[i]) != null) {
                for(List l1 : helper(subC,x-c[i])) {
                    l1.add(c[i]);
                    result.add(l1);
                }
                return result;
            }
            return null;
        }
    }
}
