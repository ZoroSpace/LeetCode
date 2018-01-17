class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int result = 1;
        int lo = 0,hi = 1;
        while(hi < s.length()) {
            for(int i = hi - 1;i >= lo;i--) {
                if(s.charAt(hi) == s.charAt(i)) {
                    lo = i + 1;
                    break;
                }
            }
            result = Math.max(result,hi-lo+1);
            hi++;
        }
        return result;
    }
}
