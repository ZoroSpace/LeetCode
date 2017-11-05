class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        int[] temp = new int[rowIndex+1];
        for(int i = 0;i < rowIndex/2+1;i++) {
            temp[i] = combination(rowIndex,i);
        }
        for(int i = rowIndex/2+1;i < rowIndex+1;i++) {
            temp[i]=temp[rowIndex-i];
        }
        for(int i = 0;i < temp.length;i++) {
            result.add(temp[i]);
        }
        return result;
    }
    int combination(int n,int k) {
        if(n == k || k == 0) return 1;
        if(k > n/2) return combination(n,n-k);
        double c = Math.max(combination(n,k-1)/k * (n-k+1),(n-k+1)/k * combination(n,k-1));
        c = Math.max(c,(n-k+1) * combination(n,k-1)/k);
        return (int)c;
    }
}
