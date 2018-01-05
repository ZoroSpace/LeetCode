class Solution {
    public boolean wordBreak(String string, List<String> wordDict) {
        if(wordDict.size() == 0 || wordDict.get(0).length() == 0) return false;
        return helper(string,wordDict);
    }
    boolean helper(String string, List<String> wordDict) {
        if(string.length() == 0) return true;
        for(String s : wordDict) {
            if(string.startsWith(s)) {
                return helper(string.substring(s.length()),wordDict);
            }
        }
        return false;
    }
}
