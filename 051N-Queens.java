class Solution {
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new LinkedList<>();
        if(n < 1) {
            result.add(new LinkedList<>());
            return result;
        }
        helper(new int[n],new boolean[n],new boolean[2*n],new boolean[2*n],0,n);
        return result;
    }
    void helper(int[] p,boolean[] a,boolean[] aPlus,boolean[] aMinus,int level,int n) {
        for(int i = 0;i < n;i++) {
            if(a[i] || aPlus[i+level] || aMinus[i-level+n-1]) continue;
            else {
                p[level] = i;
                if(level == n-1) {
                    List<String> list = new LinkedList<>();
                    for(int j = 0;j < n;j++) {
                        StringBuilder s = new StringBuilder("");
                        for(int k = 0;k < p[j];k++) s.append('.');
                        s.append('Q');
                        for(int k = p[j]+1;k < n;k++) s.append('.');
                        list.add(s.toString());
                    }
                    result.add(list);
                }
                a[i] = true;
                aPlus[i+level] = true;
                aMinus[i-level+n-1] = true;
                helper(p,a,aPlus,aMinus,level+1,n);
                a[i] = false;
                aPlus[i+level] = false;
                aMinus[i-level+n-1] = false;
            }
        }
    }
}
