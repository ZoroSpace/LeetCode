class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int lo = 0,hi = heights.length-1;
        return helper(heights,lo,hi);
    }
    int helper(int[] a,int lo,int hi) {
        if(lo > hi) return 0;
        if(lo == hi) return a[hi];
        int min = a[lo];
        for(int i = lo;i <= hi;i++) {
            min = Math.min(min,a[i]);
        }
        int index = lo;
        for(;index <= hi;index++) {
            if(a[index] == min) break;
        }
        int result;
        result = Math.max((hi-lo+1)*min,helper(a,lo,index-1));
        result = Math.max(result,helper(a,index+1,hi));
        return result;
    }
}
