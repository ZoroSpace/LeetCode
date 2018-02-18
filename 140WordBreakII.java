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
