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


class Solution {
    public int largestRectangleArea(int[] a) {
        if(a.length == 0) return 0;
        int n = a.length;
        int[] left = new int[n],right = new int[n];
        left[0] = 0;
        right[n-1] = n-1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int j;
        for(int i = 1;i < n;i++) {
            if(a[i] > a[i-1]) {
                left[i] = i;
            } else if(a[i] == a[i-1]) left[i] = left[i-1];
            else {
                while(stack.size() != 0 && a[stack.peek()] >= a[i]) stack.pop();
                if(stack.size() == 0) left[i] = 0;
                else left[i] = stack.peek()+1;
            }
                stack.push(i);                
        }
        stack.clear();
        stack.push(n-1);
        for(int i = n-2;i >= 0;i--) {
            if(a[i] > a[i+1]) right[i] = i;
            else if(a[i] == a[i+1]) right[i] = right[i+1];
            else {
                while(stack.size() != 0 && a[stack.peek()] >= a[i]) stack.pop();
                if(stack.size() == 0) right[i] = n-1;
                else right[i] = stack.peek()-1;
            }
            stack.push(i);
        }
        for(int i = 0;i < n;i++) {
            result = Math.max(result,(right[i]-left[i]+1)*a[i]);
        }
        return result;
    }
}
