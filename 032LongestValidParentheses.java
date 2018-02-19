class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int result = 0;
        boolean[][] dp = new boolean[n+1][n+1];
        Stack<Character> stack = new Stack<>();
        for(int i = 1;i <= n;i++) dp[i][i-1] = true;
        for(int i = 1;i <= n;i++) {
            stack.clear();
            for(int j = i;j <= n;j++) {
                if(s.charAt(j-1) == '(') stack.push('(');
                else {
                    if(dp[i][j-1]) {
                        for(int k = j;k <= n;k++) dp[i][k] = false;
                        break;
                    } else {
                        stack.pop();
                        if(stack.empty()) dp[i][j] = true;
                    }
                }
                if(dp[i][j]) result = Math.max(j-i+1,result);
            }
        }
        return result;
    }
}


class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int counter;
        for(int i = 0;i < n;i++) {
            counter = 0;
            while(!stack.empty() && stack.peek() != -1 && stack.peek() != -2) {
                counter = stack.pop() + counter;
            }
            if(s.charAt(i) == '(') {
                stack.push(counter);
                stack.push(-1);
            } else {
                if(!stack.empty() && stack.peek() == -1) {
                    stack.pop();
                    stack.push(counter+2);
                } else {
                    stack.push(counter);
                    stack.push(-2);
                }
                
            }            
        }
        counter = 0;
        for(int i : stack) {
            if(i == -1 || i == -2) counter = 0;
            else {
                counter += i;
                result = Math.max(result,counter);
            }
        }
        return result;
    }
}


class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int counter = 0;
        for(int i = 0;i < n;i++) {
            counter = 0;
            if(!(stack.empty() || stack.peek() == -1 || stack.peek() == -2)) {
                counter = stack.pop();
            }
            if(s.charAt(i) == '(') {
                if(counter != 0) stack.push(counter);
                stack.push(-1);
            } else {
                if(!stack.empty() && stack.peek() == -1) {
                    stack.pop();
                    stack.push(counter+2);
                } else {
                    if(counter != 0) stack.push(counter);
                    stack.push(-2);
                }
            }
            counter = 0;
            while(!(stack.empty() || stack.peek() == -1 || stack.peek() == -2)) {
                counter += stack.pop();
            }
            if(counter != 0) {
                stack.push(counter);
                result = Math.max(result,counter);
            }
        }
        return result;
    }
}
