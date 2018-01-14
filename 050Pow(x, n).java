class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        if(n >= 0) {
            for(int i = 0;i < n;i++) {
                result = result * x;
            }
        } else {
            result = 1/myPow(x,-n);
        }
        return result;
    }
}
