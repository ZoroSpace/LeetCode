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

class Solution {
    HashMap<Integer,Integer> map;
    int r;
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        map = new HashMap<>();
        r = n;
        for(int i = 0;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                if(isP(s,i,j)) map.put(i,j);
            }
        }
        helper(s,-1,0,n);
        return r - 1;
        
    }
    void helper(String s,int lo,int level,int left) {
        if(level > r) return;
        boolean flag = true;
        for(int i : map.keySet()) {
            if(i > lo) {
                helper(s,map.get(i),level+1,left-(map.get(i)-i+1));
                flag = false;
            }
        }
        if(flag) r = Math.min(r,level+left);
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


class Solution {
    boolean[][] visited;
    boolean[][] isP;
    int result;
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        result = n;
        visited = new boolean[n][n];
        isP = new boolean[n][n];
        for(int i = n-1;i > -1;i--) {
            isP[i][i] = true;
            for(int j = i+1;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)&&(isP[i+1][j-1] || j == i+1))
                    isP[i][j] = true;
            }
        }
        dfs(s,0,0);
        return result - 1;
    }
    
    void dfs(String s,int index,int level) {
        if(index == s.length()) {
            result = Math.min(result,level);
            return;
        }
        if(visited[level][index]) return;
        visited[level][index] = true;
        for(int i = s.length()-1;i >= index;i--) {
            if(isP[index][i] && level < result) dfs(s,i+1,level+1);
        }
    }
}
