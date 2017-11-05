class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        for(int i = 0;i < rowIndex+1;i++) {
            result.add(combination(rowIndex,i));
        }
        return result;
    }
    int combination(int n,int k) {
        if(n == k || k == 0) return 1;
        
        if(k > n/2) return combination(n,n-k);
        
        return combination(n,k-1) * (n-k+1)/k;
    }
}
