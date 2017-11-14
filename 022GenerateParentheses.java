class Solution {
	public List<String> generateParenthesis(int n) {
		Stack<Character> lsk = new Stack<>();
		Stack<Character> rsk = new Stack<>();
		
		
	}
	String helper(Stack<Character> lsk,Stack<Character> rsk) {
		if(lsk.size() = rsk.size()) {
			return lsk.pop() + helper(lsk,rsk);
		} else if(lsk.size() == 0) {
			return rsk.pop() + helper(lsk,rsk);
		} else if(rsk.size() == 0) {
			return lsk.pop() + helper(lsk,rsk);
	}
}
