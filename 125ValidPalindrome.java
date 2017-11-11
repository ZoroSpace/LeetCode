class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            while(!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')||(s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                if(i == j) break;
                i++;
            }
            while(!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') ||(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')||(s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                if(i == j) break;
                j--;
            }
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9')&&(s.charAt(i) != s.charAt(j))) {
                return false;
            }
            if(!(s.charAt(i) == s.charAt(j) ||s.charAt(i) == s.charAt(j) + 'Z'-'z'||s.charAt(i) == s.charAt(j)+'z'-'Z')) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
