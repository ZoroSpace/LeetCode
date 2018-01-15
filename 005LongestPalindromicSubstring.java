class Solution {
    public String longestPalindrome(String s) {
        s = "*" + s;
        int[][] dp = new int[2][s.length()];//用于记录dp[1][i]和i之间为回文,inclusive;和回文字符串的长度
        int longest = 0;
        boolean flag = false;
        dp[0][1] = 1;
        dp[1][1] = 0;
        char cur;
        for(int i = 2;i < dp[0].length;i++) {
            //计算dp[0]
            cur = s.charAt(i);
            
            if(cur == s.charAt(dp[0][i-1]-1)) dp[0][i] = dp[0][i-1]-1;
            else {
                if(cur != s.charAt(i-1))  {
                    dp[0][i] = i;
                } else {
                    dp[0][i] = flag ? dp[0][i-1] : i-1;
                }
            }
            flag = cur == s.charAt(i-1) ? true:false;
            //计算dp[1]
            dp[1][i] = i - dp[0][i];
            longest = Math.max(longest,dp[1][i]);
        }
        int i;
        for(i = 1;i < dp[0].length;i++) {
            if(dp[1][i] == longest) break;
        }
        return s.substring(dp[0][i],i+1);
    }
}
