class Solution {
    public int reverse(int x) {
        long result;
        if(x >=0) result = helper(x);
        else result = 0 - helper(0-x);
        if(result > 2147483647 || result < -2147483648) return 0;
        else return (int)result;
    }
    
    long helper(int x) {
        long result = 0;
        while(x > 0) {
            result = 10 * result + x % 10;
            x = x / 10;
        }
        return result;
    }
}
// 32位int的取值范围 min:-2147483648  max:2147483647
