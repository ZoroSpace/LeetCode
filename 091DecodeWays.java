class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i < dp.length;i++) {
            if(s.charAt(i-1) == '0' && s.charAt(i-2) != '2'  && s.charAt(i-2) != '1') return 0;
            if(s.charAt(i-1) == '0') dp[i] = dp[i-2];
            else if(s.charAt(i-2) == '1'||(s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) dp[i] = dp[i-1] + dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }
}
