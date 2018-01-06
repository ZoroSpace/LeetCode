class Solution {
    public boolean wordBreak(String string, List<String> wordDict) {
        if(wordDict.size() == 0 || wordDict.get(0).length() == 0) return false;
        boolean[] dp = new boolean[string.length()];
        for(int i = string.length() - 1;i > -1;i--) {
            for(String s : wordDict) {
                if(i + s.length() < string.length()) {
                    dp[i] = string.startsWith(s,i) && dp[i + s.length()];
                } else dp[i] = string.startsWith(s,i);
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
