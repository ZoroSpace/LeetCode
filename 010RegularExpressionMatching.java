class Solution {
    public boolean isMatch(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        boolean[][] a = new boolean[n1+1][n2+1];
        boolean flag = false;
        a[0][0] = true;
        for(int i = 1;i < n2+1;i++) {
            if(s2.charAt(i-1) == '*') a[0][i] = true;
        }
        for(int i = 1;i < n1+1;i++) {
            flag = false;
            for(int j = 1;j < n2+1;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '.') {
                    a[i][j] = a[i-1][j-1];
                    flag = true;
                } else if(s2.charAt(j-1) == '*') {
                    a[i][j] = flag;
                }
            }
        }
        return a[n1][n2];
    }
}

class Solution {
    public boolean isMatch(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        boolean[][] a = new boolean[n1+1][n2+1];
        boolean flag = false;
        a[0][0] = true;
        int begin = 0;
        int cur;
        for(int i = 1;i < n2+1;i++) {
            if(s2.charAt(i-1) == '*') a[0][i] = true;
        }
        
        for(int i = 1;i < n1+1;i++) {
            flag = false;
            for(int j = 1;j < n2+1;j++) {
                if(a[i][j]) continue;
                if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '.') {
                    a[i][j] = a[i-1][j-1];
                    if(a[i][j]) flag = true;
                } else if(s2.charAt(j-1) == '*') {
                    cur = j-1;
                    a[i][j] = flag;
                    if(a[i][j]) {
                        for(int k = begin;k < cur;k++) {
                            int t = i;
                            while(t+cur-k <= s1.length()&&match(s1.substring(t,t+cur-k),s2.substring(k,cur))) {
                                a[t+cur-k][j] = true;
                                t = t+cur-k;
                            }
                        }
                    }
                    begin = cur+1;
                }
                
            }
        }
        return a[n1][n2];
    }
    boolean match(String s1,String s2) {
        int n = s1.length();
        for(int i = 0;i < n;i++) {
            if(s2.charAt(i) != '.' && s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
