class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] result = new int[n];
        for(int i = 0;i < n;i++) {
            result[i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2;i > -1;i--) {
            List<Integer> l = triangle.get(i);
            for(int j = 0;j < i+1;j++) {
                result[j] = l.get(j) + Math.min(result[j],result[j+1]);
            }
        }
        return result[0];
    }
}
