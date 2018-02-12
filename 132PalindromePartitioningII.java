class Solution {
    boolean[][] P;
    public int minCut(String s) {
        
        int n = s.length();
        if(n <= 1) return 0;
        P = new boolean[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = i;j < n;j++) {
                if(isP(s,i,j)) P[i][j] = true;
            }
        }
        return helper(s,0,n-1)-1;
        
    }
    int helper(String s,int lo,int hi) {
        if(lo == hi) return 1;
        int result = hi-lo+1;
        for(int i = lo;i <= hi;i++) {
            if(P[lo][i]) {
                result = Math.min(result,helper(s,i+1,hi)+1);
            }
        }
        return result;
    }
    boolean isP(String s,int lo,int hi) {
        while(lo < hi) {
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}

class Solution {
    boolean[][] P;
    int r;
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        P = new boolean[n][n];
        r = n;
        for(int i = 0;i < n;i++) {
            for(int j = i;j < n;j++) {
                if(isP(s,i,j)) P[i][j] = true;
            }
        }
        helper(s,0,n-1,1);
        return r - 1;
        
    }
    void helper(String s,int lo,int hi,int level) {
        if(level > r) return;
        if(P[lo][hi]) {
            r = Math.min(r,level);
            return;
        }
        int result = hi-lo+1;
        for(int i = lo;i <= hi;i++) {
            if(P[lo][i]) {
                helper(s,i+1,hi,level+1);
            }
        }
        return;
    }
    boolean isP(String s,int lo,int hi) {
        while(lo < hi) {
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}

