class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> l1;
        if(k == 1) {
            for(int i = 1;i < n+1;i++) {
                l1 = new LinkedList<>();
                l1.add(i);
                result.add(l1);
            }
            return result;
        } else if(n == k) {
            l1 = new LinkedList<>();
            for(int i = 1;i < n+1;i++) {
                l1.add(i);
            }
            result.add(l1);
            return result;
        } else {
            for(List l2 : combine(n-1,k-1)) {
                l2.add(n);
                result.add(l2);
            }
            for(List l2 : combine(n-1,k)) {
                result.add(l2);
            }
            return result;
        }
    }
}
