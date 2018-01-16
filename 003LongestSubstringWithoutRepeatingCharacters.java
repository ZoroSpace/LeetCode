class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int result = 1;
        boolean flag = false;
        int lo = 0,hi = 1;
        while(hi < s.length()) {
            if(s.charAt(hi) == s.charAt(hi - 1)) {
                flag = true;
                hi++;
            } else if(flag) {
                lo = hi - 1;
                dp[hi] = 2;
                result = Math.max(result,dp[hi]);
                flag = false;
                hi++;
            } else {
                if(s.charAt(lo) == s.charAt(hi)) {
                    lo++;
                    dp[hi] = hi-lo+1;
                    result = Math.max(result,dp[hi]);
                    hi++;
                    flag = false;
                } else {
                    dp[hi] = hi-lo+1;
                    result = Math.max(result,dp[hi]);
                    hi++;
                    flag = false;
                }
            }
        }
        return result;
    }
}
