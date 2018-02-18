class Solution {
    LinkedList<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new LinkedList<>();
        helper(s,0,wordDict,new StringBuilder(""));
        return result;
    }
    void helper(String s,int index,List<String> wordDict,StringBuilder sb) {
        if(index == s.length()) {
            result.addFirst(sb.substring(0,sb.length()-1));
            return;
        }
        for(int i = index+1;i <= s.length();i++) {
            String t = s.substring(index,i);
            if(wordDict.contains(t)) {
                StringBuilder nsb = new StringBuilder(sb.toString());
                nsb.append(t).append(" ");
                helper(s,i,wordDict,nsb);
            }
        }
        return;
    }
}


class Solution {
    LinkedList<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new LinkedList<>();
        if(!breakable(s,wordDict)) return result;
        helper(s,0,wordDict,new StringBuilder(""));
        return result;
    }
    void helper(String s,int index,List<String> wordDict,StringBuilder sb) {
        if(index == s.length()) {
            result.add(sb.substring(0,sb.length()-1));
            return;
        }
        for(int i = index+1;i <= s.length();i++) {
            String t = s.substring(index,i);
            if(wordDict.contains(t)) {
                StringBuilder nsb = new StringBuilder(sb.toString());
                nsb.append(t).append(" ");
                helper(s,i,wordDict,nsb);
            }
        }
        return;
    }
    boolean breakable(String s,List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1;i <= n;i++) {
            if(dp[i-1]) {
                for(String string : wordDict) {
                    if(s.startsWith(string,i-1)) dp[i+string.length()-1] = true;
                }
            }
                
        }
        return dp[n];
    }
}
