class Solution {
    public int divide(int dividend, int divisor) {
        //dividend:被除数;divisor:除数;
        if(dividend < 0 && divisor < 0) return divide(-dividend,-divisor);
        if(dividend > 0 && divisor < 0) return -divide(dividend,-divisor);
        if(dividend < 0 && divisor > 0) return -divide(-dividend,divisor);
        return Integer.parseInt(helper(dividend,divisor).toString());
    }
    
    StringBuilder helper(int n1,int n2) {
        StringBuilder result = new StringBuilder("");
        if(n1 < n2) return result;
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);
        
        int counter = 0;
        String s3 = s1.substring(0,s2.length());
        int n3 = Integer.parseInt(s3);
        while(n3 >= n2) {
            counter++;
            n3 = n3 - n2;
        }
        
        return result.append(counter).append(helper(Integer.parseInt(n3+s1.substring(s2.length())),n2));
    }
}
