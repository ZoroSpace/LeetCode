public class Solution {
	public double myPow(double x,int n) {
		double result = 1;
		double half;
        if(n == Integer.MIN_VALUE) {
            result = myPow(x*x,n/2);
        }
		else if(n == 0) ;
		else if(n > 0) {
			half = myPow(x,n/2);
			if(n % 2 == 0) result = half * half;
			else result = half * half * x;
		} else result = result/myPow(x,-n);
		return result;
	}
}
