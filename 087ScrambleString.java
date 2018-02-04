class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] dic = new int[26];
        for(int i = 0;i < s1.length();i++) {
            dic[s1.charAt(i)-'a']++;
            dic[s2.charAt(i)-'a']--;
        }
        for(int i = 0;i < 26;i++) {
            if(dic[i] != 0) return false;
        }
        return true;
    }
}
