class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = p.length(),n2 = s.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        
        for(int i = 1;i < n1+1;i++) {
            if(p.charAt(i-1) == '*') dp[i][0] = true;
            else break;
        }
        int position;
        for(int i = 1;i < n1+1;i++) {
            for(position = 0;position < n2+1;position++) {
                if(dp[i-1][position]) break;
            }
            for(int j = 1;j < n2+1;j++) {
                if(p.charAt(i-1) != '*' && p.charAt(i-1) != '?') {
                    if(p.charAt(i-1) == s.charAt(j-1) && dp[i-1][j-1]) dp[i][j] = true;
                } else if(p.charAt(i-1) == '?') {
                    if(dp[i-1][j-1]) dp[i][j] = true;
                } else {
                    if(j >= position) dp[i][j] = true;
                }
            }
        }
        return dp[n1][n2];
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = p.length(),n2 = s.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        for(int i = 1;i < n1+1;i++) {
            if(p.charAt(i-1) == '*') dp[i][0] = true;
            else break;
        }
        for(int i = 1;i < n1+1;i++) {
            for(int j = 1;j < n2+1;j++) {
                if(p.charAt(i-1) == '*') {
                    if(dp[i-1][j] || dp[i][j-1]) dp[i][j] = true;
                } else if(p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1)) {
                    if(dp[i-1][j-1]) dp[i][j] = true;
                }
            }
        }
        return dp[n1][n2];
    }
}
