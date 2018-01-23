class Solution {
    public int totalNQueens(int n) {
        //test case : n  <= 13
        if(n <= 1) return 1;
        int[] a = new int[n];
        for(int i = 0;i < n;i++) a[i] = -1;
        return helper(a,0,0);
    }
    
    int helper(int[] a,int level,int counter) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < a.length;i++) set.add(i);
        for(int i = 0;i < level;i++) {
            set.remove(a[i]);
            set.remove(a[i]+i-level);
            set.remove(a[i]+level-i);
        }
        if(set.isEmpty()) return counter;
        else if(set.size() == 1 && level == a.length-1) return 1; 
        else {
            for(int i : set) {
                a[level] = i;
                counter = counter+helper(a,level+1,counter);
            }
        }
        return counter;
    }
}
