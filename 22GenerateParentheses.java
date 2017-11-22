class Solution {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> strings = new LinkedList<>();//offer() poll()
        if(n == 0) {
            strings.add("");
            return strings;
        }
        LinkedList<Integer> nums = new LinkedList<>();
        strings.offer("(");
        nums.offer(1);
        int stringSize;
        int numSize;
        String s;
        int counter;
        for(int i = 0;i < 2*n - 1;i++) {
            stringSize = strings.size();
            for(int j = 0;j < stringSize;j++) {
                s = strings.poll();
                counter = nums.poll();
                if(counter + i == 2 * n - 1) {
                    strings.offer(s+")");
                    nums.offer(counter - 1);
                }else if(counter == 0) {
                    counter++;
                    strings.offer(s+"(");
                    nums.offer(1);
                } else {
                    strings.offer(s+")");
                    nums.offer(counter - 1);
                    strings.offer(s+"(");
                    nums.offer(counter + 1);
                }
            }
        }
        return strings;
        
    }
    
}
