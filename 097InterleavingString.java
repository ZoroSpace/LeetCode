class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        return helper(s1,s2,s3,0,0,0);
    }
    
    boolean helper (String s1,String s2,String s3,int i1,int i2,int i3) {
        if(i3 == s3.length()) return true;
        if(i1 < s1.length() && s1.charAt(i1) != s3.charAt(i3) && i2 < s2.length() && s2.charAt(i2) != s3.charAt(i3)) return false;
        boolean flag1,flag2;
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            flag1 = helper(s1,s2,s3,i1+1,i2,i3+1);
            if(flag1) return true;
        }
        if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            flag2 = helper(s1,s2,s3,i1,i2+1,i3+1);
            if(flag2) return true;
        }
        return false;
    }
}
