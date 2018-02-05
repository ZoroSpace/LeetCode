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
        String s3,s4,s5,s6;
        boolean flag = false;
        for(int i = 1;i < s1.length();i++) {
            s3 = s1.substring(0,i);
            s4 = s2.substring(0,i);
            s5 = s1.substring(i,s1.length());
            s6 = s2.substring(i,s1.length());
            flag = (helper(s3,s4) || helper(s3,new StringBuffer(s4).reverse().toString()))&&(helper(s5,s6) || helper(s5,new StringBuffer(s6).reverse().toString()));
            if(flag) return true;
        }
        return false;
        
    }
}
