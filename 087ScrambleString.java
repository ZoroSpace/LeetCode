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
        return helper(s1,s2) || helper(s1,new StringBuffer(s2).reverse().toString());
    }
        
    boolean helper(String s1,String s2) {
        if(s1.equals(s2)) return true;
        int[] dic = new int[26];
        for(int i = 0;i < s1.length();i++) {
            dic[s1.charAt(i)-'a']++;
            dic[s2.charAt(i)-'a']--;
        }
        for(int i = 0;i < 26;i++) {
            if(dic[i] != 0) return false;
        }
        String s3,s4,s5,s6;
        boolean flag = false;
        for(int i = 1;i < s1.length();i++) {
            flag = helper(s1.substring(0,i),s2.substring(0,i)) && helper(s1.substring(i,s1.length()),s2.substring(i,s1.length()));
            if(flag) return true;
            flag = helper(s1.substring(0,i),s2.substring(s1.length()-i,s1.length())) && helper(s1.substring(i,s1.length()),s2.substring(0,s1.length()-i));
            if(flag) return true;
        }
        return false;
        
    }
}
