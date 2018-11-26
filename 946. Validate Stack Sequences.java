class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length <= 2) return true;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.offerLast(pushed[0]);
        int push_index = 1;
        int pop_index = 0;
        while (pop_index < popped.length) {
            if (!stack.isEmpty() && stack.peekLast() == popped[pop_index]) {
                pop_index++;
                stack.pollLast();
            } else {
                if (push_index == pushed.length) return false;
                stack.offerLast(pushed[push_index]);
                push_index++;
            }
        }
        return stack.isEmpty();
    }
}
