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


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        return helper1(s1,s2,s3,0,0,0,s1.length()-1,s2.length()-1,s3.length()-1);
    }
    
    boolean helper1(String s1,String s2,String s3,int i1,int i2,int i3,int j1,int j2,int j3) {
        if(i3 > j3) return true;
        if(i1 <= j1 && s1.charAt(i1) != s3.charAt(i3) && i2 <= j2 && s2.charAt(i2) != s3.charAt(i3)) return false;
        boolean flag1,flag2;
        if(i1 <= j1 && s1.charAt(i1) == s3.charAt(i3)) {
            flag1 = helper2(s1,s2,s3,i1+1,i2,i3+1,j1,j2,j3);
            if(flag1) return true;
        }
        if(i2 <= j2 && s2.charAt(i2) == s3.charAt(i3)) {
            flag2 = helper2(s1,s2,s3,i1,i2+1,i3+1,j1,j2,j3);
            if(flag2) return true;
        }
        return false;
    }
    
    boolean helper2(String s1,String s2,String s3,int i1,int i2,int i3,int j1,int j2,int j3) {
        if(i3 > j3) return true;
        if(i1 <= j1 && s1.charAt(j1) != s3.charAt(j3) && i2 <= j2 && s2.charAt(j2) != s3.charAt(j3)) return false;
        boolean flag1,flag2;
        if(i1 <= j1 && s1.charAt(j1) == s3.charAt(j3)) {
            flag1 = helper1(s1,s2,s3,i1,i2,i3,j1-1,j2,j3-1);
            if(flag1) return true;
        }
        if(i2 <= j2 && s2.charAt(j2) == s3.charAt(j3)) {
            flag2 = helper1(s1,s2,s3,i1,i2,i3,j1,j2-1,j3-1);
            if(flag2) return true;
        }
        return false;
    }
}
