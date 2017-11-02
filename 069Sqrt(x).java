class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int lo = 1;
        int hi = x;
        int mid;
        while(lo < hi) {
            mid = (lo + hi)/2;
            if(mid == x/mid) return mid;
            if(mid < x/mid) {
                if(mid * 2 < lo + hi) lo = mid + 1;
                else lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi - 1;
    }
}
