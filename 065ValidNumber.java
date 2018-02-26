class Solution {
    public boolean isNumber(String s) {
        int lo = 0,hi = s.length() - 1;
        while(lo < s.length() && s.charAt(lo) == ' ')  lo++;
        if(lo == s.length()) return false;
        while(hi >= lo && s.charAt(hi) == ' ') hi--;
        s = s.substring(lo,hi+1);
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1,s.length());
        return isInt(s) || isDecimal(s) || isSpec(s);
    }
    
    boolean isInt(String s) {
        if(s.length() == 0) return false;
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
        }
        return true;
    }
    
    boolean isDecimal(String s) {
        int index = 0;
        while(index < s.length() && s.charAt(index) != '.') index++;
        if(index == s.length()) return false;
        if(index == 0 && isInt(s.substring(index+1,s.length()))) return true;
        if(index == s.length() - 1 && isInt(s.substring(0,index))) return true;
        return isInt(s.substring(0,index)) && isInt(s.substring(index+1,s.length()));
    }
    
    boolean isSpec(String s) {
        int index = 0;
        while(index < s.length() && s.charAt(index) != 'e') index++;
        if(index == s.length() || index == s.length() - 1 || s.length() == 0) return false;
        String first = s.substring(0,index);
        String second = s.substring(index+1,s.length());
        if(second.charAt(0) == '-' || second.charAt(0) == '+') second = second.substring(1,second.length());
        return (isInt(first) || isDecimal(first)) && isInt(second);
    }
}
