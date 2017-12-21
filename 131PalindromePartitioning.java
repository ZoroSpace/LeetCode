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
        List<List<String>> result = new LinkedList<>();
        LinkedList<String> one = new LinkedList<>();
        if(lo == hi) {
            one.add(String.valueOf(Arrays.copyOfRange(c,lo,hi+1)));
            result.add(one);
        } else if(lo > hi) {
            result.add(one);
        } else {
            for(int i = lo;i < hi+1;i++) {
                if(isPalindrome(c,lo,i)) {
                    List<List<String>> rest = helper(c,i+1,hi);//
                    if(rest != null) {
                        for(List<String> l : rest) {
                            l.add(0,String.valueOf(Arrays.copyOfRange(c,lo,i+1)));
                            result.add(l);
                        }
                    }
                }
            }
        }
        return result;
    }
}
