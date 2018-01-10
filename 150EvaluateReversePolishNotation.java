class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens[0].length() == 0) return 0;
        Deque<Integer> nums = new LinkedList<>();
        int n1,n2,n3=0;
        for(String s : tokens) {
            char c = s.charAt(s.length()-1);
            if('0' <= c && c <= '9') nums.offerLast(Integer.parseInt(s));
            else {
                n1 = nums.pollLast();
                n2 = nums.pollLast();
                switch(c) {
                    case '+' :
                        n3 = n2+n1;
                        break;
                    case '-' :
                        n3 = n2-n1;
                        break;
                    case '*' :
                        n3 = n2*n1;
                        break;
                    case '/' :
                        n3 = n2/n1;
                        break;
                    default :
                        break;
                }
                nums.offerLast(n3);
            }
        }
        return nums.pollLast();
    }
}
