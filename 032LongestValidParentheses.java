class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int result = 0;
        boolean[][] dp = new boolean[n+1][n+1];
        Stack<Character> stack = new Stack<>();
        for(int i = 1;i <= n;i++) dp[i][i-1] = true;
        for(int i = 1;i <= n;i++) {
            stack.clear();
            for(int j = i;j <= n;j++) {
                if(s.charAt(j-1) == '(') stack.push('(');
                else {
                    if(dp[i][j-1]) {
                        for(int k = j;k <= n;k++) dp[i][k] = false;
                        break;
                    } else {
                        stack.pop();
                        if(stack.empty()) dp[i][j] = true;
                    }
                }
                if(dp[i][j]) result = Math.max(j-i+1,result);
            }
        }
        return result;
    }
}
