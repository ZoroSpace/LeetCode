class Solution {
    public int maximalRectangle(char[][] a) {
        if(a.length == 0 || a[0].length == 0) return 0;
        int m = a.length,n = a[0].length;
        int[] height = new int[n],left = new int[n],right = new int[n];
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(a[i][j] == '0') height[j] = 0;
                else height[j] = height[j]+1;
            }
            stack.clear();
            stack.push(0);
            for(int j = 1;j < n;j++) {
                if(height[j] > height[j-1]) left[j] = j;
                else {
                    while(stack.size() != 0 && height[stack.peek()] >= height[j]) stack.pop();
                    if(stack.size() == 0) left[j] = 0;
                    else left[j] = stack.peek() + 1;
                }
                stack.push(j);
            }
            stack.clear();
            stack.push(n-1);
            right[n-1] = n-1;
            for(int j = n-2;j >=0;j--) {
                if(height[j] > height[j+1]) right[j] = j;
                else {
                    while(stack.size() != 0 && height[stack.peek()] >= height[j]) stack.pop();
                    if(stack.size() == 0) right[j] = n-1;
                    else right[j] = stack.peek()-1;
                }
                stack.push(j);
            }
            for(int j = 0;j < n;j++) result = Math.max(result,(right[j] - left[j] + 1) * height[j]);
        }
        return result;
    }
}
