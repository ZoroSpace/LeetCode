class Solution {
    public int totalNQueens(int n) {
        //test case : n  <= 13
        if(n <= 1) return 1;
        int[] a = new int[n];
        for(int i = 0;i < n;i++) a[i] = -1;
        int counter = 0;
        for(int i = 0;i < n/2;i++) {
            a[0] = i;
            counter = counter+helper(a,1,0);
            a[0] = -1;
        }
        if(n%2 == 0) return 2*counter;
        else {
            a[0] = n/2;
            return counter*2+helper(a,1,0);
        }
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
        else if(set.size() == 1 && level == a.length-1) return counter+1; 
        else {
            for(int i : set) {
                a[level] = i;
                counter = helper(a,level+1,counter);
            }
        }
        return counter;
    }
}


class Solution {
    public int totalNQueens(int n) {
        //test case : n  <= 13
        if(n <= 1) return 1;
        int[] a = new int[n];
        // return helper(a,1,0);
        int counter = 0;
        for(int i = 0;i < n/2;i++) {
            a[0] = i;
            counter = counter+helper(a,2,0);
            a[0] = -1;
        }
        if(n%2 == 0) return 2*counter;
        else {
            a[0] = n/2;
            return counter*2+helper(a,2,0);
        }
    }
    
    int helper(int[] a,int level,int counter) {
        for(int i = 0;i < a.length;i++) {
            a[level-1] = i;
            if(isValid(a,level)) {
                if(level == a.length) return counter+1;
                counter = helper(a,level+1,counter);
            }
        }
        return counter;
    }
    boolean isValid(int[] a,int level) {
        for(int i = 0;i< level-1;i++) {
            if(a[i] == a[level-1] || (Math.abs(a[i] - a[level-1])==Math.abs(i-level+1)))
                return false;
        }
        return true;
    }
}

class Solution {
    private int counter;
    public int totalNQueens(int n) {
        counter = 0;
        if(n <= 1) return 1;
        helper(new int[n],new boolean[n],new boolean[2*n],new boolean[2*n],0,n);
        return counter;
    }
    void helper(int[] p,boolean[] a,boolean[] aPlus,boolean[] aMinus,int level,int n) {
        for(int i = 0;i < n;i++) {
            if(a[i] || aPlus[i+level] || aMinus[i-level+n-1]) continue;
            else {
                p[level] = i;
                if(level == n-1) counter++;
                a[i] = true;aPlus[i+level] = true;aMinus[i-level+n-1] = true;
                helper(p,a,aPlus,aMinus,level+1,n);
                a[i] = false;aPlus[i+level] = false;aMinus[i-level+n-1] = false;
            }
        }
    }
}
