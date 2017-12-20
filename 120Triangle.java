class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] result = new int[n];
        for(int i = 0;i < n;i++) {
            result[i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2;i > -1;i--) {
            List<Integer> l = triangle.get(i);
            result[0] = triangle.get(i).get(0) + Math.min(result[0],result[1]);
            for(int j = 1;j < i;j++) {
                result[j] = triangle.get(i).get(j) + Math.min(Math.min(result[i-1],result[i]),result[i+1]);
            }
        }
        return result[0];
    }
}
