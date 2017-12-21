class Solution {
    public List<List<String>> partition(String s) {
        char[] c = s.toCharArray();
        List<List<String>> result = new LinkedList<>();
        
        return null;
    }
    
    boolean isPalindrome(char[] c,int lo,int hi) {
        while(lo < hi) {
            if(c[lo] == c[hi]) {
                lo++;
                hi--;
            } else return false;
        }
        return true;
    }
}
