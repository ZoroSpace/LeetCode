class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return s;
        s = "*" + s;
        ArrayList<Integer>[] match = new ArrayList[s.length()];//用于记录第i项和第ArrayList里的项之间构成回文序列
        for(int i=0;i<match.length;i++) {
            match[i]=new ArrayList<Integer>();
        }
        int[] span = new int[s.length()];//用于记录第i项构成回文序列的最长长度
        
        match[1].add(1);//初始化
        span[1] = 0;
        int longest = 0;
        
        boolean flag = false;
        char cur;
        
        for(int i = 2;i < s.length();i++) {
            //计算match
            cur = s.charAt(i);
            for(int j : match[i-1]) {
                if(cur == s.charAt(j - 1)) match[i].add(j - 1);
            }
            if(cur != s.charAt(i-1))  {
                match[i].add(i);
            } else {
                if(!flag) match[i].add(i-1);
                else match[i].add(match[i-1].get(0));
            }
            flag = cur == s.charAt(i-1) ? true:false;
            
            //span
            span[i] = i - match[i].get(0);
            longest = Math.max(longest,span[i]);
        }
        int i;
        for(i = 1;i < span.length;i++) {
            if(span[i] == longest) break;
        }
        return s.substring(match[i].get(0),i+1);
    }
}
