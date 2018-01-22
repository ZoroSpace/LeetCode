class Solution {
    public int divide(int dividend, int divisor) {
        //dividend:被除数;divisor:除数;
        //-2147483648,2147483647
        if(divisor == Integer.MIN_VALUE) {
            if(dividend == Integer.MIN_VALUE) return 1;
            return 0;
        }
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == 1) return dividend;
            if(divisor == -1) return Integer.MAX_VALUE;
            if(divisor == 2) return divide(dividend+1,2)-1;
            if(divisor == -2) return -divide(dividend,2);
            else dividend = dividend+1;
        }
        
        if(dividend < 0 && divisor < 0) return divide(-dividend,-divisor);
        if(dividend > 0 && divisor < 0) return -divide(dividend,-divisor);
        if(dividend < 0 && divisor > 0) return -divide(-dividend,divisor);
        if(dividend < divisor) return 0;
        StringBuilder result = new StringBuilder("");
        String dividendString = String.valueOf(dividend);
        String divisorString = String.valueOf(divisor);
        int counter = 0;
        char last = '0';
        StringBuilder numString = new StringBuilder("");
        int n1 = Integer.parseInt(dividendString.substring(0,divisorString.length()));
        for(int i = 0;i < dividendString.length()-divisorString.length()+1;i++) {
            numString.delete(0,numString.length());
            while(n1 >= divisor) {
                n1 = n1 - divisor;
                counter++;
            }
            result.append(counter);
            if(i+divisorString.length() == dividendString.length()) break;
            numString.append(String.valueOf(n1)).append(dividendString.charAt(i+divisorString.length()));
            n1 = Integer.parseInt(numString.toString());
            counter = 0;
        }
        return Integer.parseInt(result.toString());
    }
}
