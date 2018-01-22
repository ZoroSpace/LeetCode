class Solution {
    public int divide(int dividend, int divisor) {
        //dividend:被除数;divisor:除数;
        //-2147483648,2147483647
        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if(divisor == Integer.MIN_VALUE) return 0;
        boolean flag = true;
        if(dividend > 0 && divisor > 0) {
            if(dividend < divisor) return 0;
            flag = true;
        }
        if(dividend < 0 && divisor < 0) {
            if(dividend > divisor) return 0;
            flag = true;
        }
        if(dividend > 0 && divisor < 0) {
            if(-dividend > divisor) return 0;
            flag = false;
        }
        if(dividend < 0 && divisor > 0) {
            if(dividend > -divisor) return 0;
            flag =false;
        }

        StringBuilder result = new StringBuilder("");
        String dividendString = String.valueOf(dividend);
        String divisorString = String.valueOf(divisor);
        if(dividend < 0) {
            dividendString = dividendString.substring(1);
        }
        if(divisor < 0) {
            divisorString = divisorString.substring(1);
            divisor = Integer.parseInt(divisorString);
        }
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
        if(flag && result.toString().equals("2147483648")) return 2147483647;
        if(flag) return Integer.parseInt(result.toString());
        else return Integer.parseInt("-"+result.toString());
    }
}
