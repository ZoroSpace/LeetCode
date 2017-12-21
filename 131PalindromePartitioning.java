class Solution {
    public List<List<String>> partition(String s) {
        char[] c = s.toCharArray();
        // List<List<String>> result = new LinkedList<>();
        return helper(c,0,s.length()-1);
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
    
    List<List<String>> helper(char[] c,int lo,int hi) {
        List<List<String>> result;
        for(int i = lo;i < hi;i++) {
            if(isPalindrome(c,lo,i)) {
                List<String> list = new LinkedList<>();
                list.add(String.valueOf(copyOfRange(c,lo,i)));
                List<List<String>> lastResult = helper(c,i+1,hi);
                if(lastResult.size() != 0) {
                    for(List<String> l : lastResult) {
                        l.add(String.valueOf(copyOfRange(c,lo,i)));
                    }
                }
            }
        }
        return lastResult;
    }
}
