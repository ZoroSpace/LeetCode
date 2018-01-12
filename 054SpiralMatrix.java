class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<>();
		if(matrix.length == 0||matrix[0].length == 0) return result;
		return helper(matrix,0,matrix[0].length-1,0,matrix.length-1);
	}
	
	List<Integer> helper(int[][] matrix,int left,int right,int top,int bottom) {
		List<Integer> cur = new LinkedList<>();
		if(left > right||top > bottom) return cur;
		List<Integer> next = helper(matrix,left+1,right-1,top+1,bottom-1);
		//加入外层数字
		for(int i = left;i <= right;i++) {
			cur.add(matrix[top][i]);
		}
		for(int i = top+1;i < bottom;i++) {
			cur.add(matrix[i][right]);
		}
		if(top < bottom) {
			for(int i = right;i >= left;i--) {
				cur.add(matrix[bottom][i]);
			}
		}
		if(left < right) {
			for(int i = bottom-1;i > top;i--) {
				cur.add(matrix[i][left]);
			}
		}
		//加入内层数字
		if(next.size() != 0) {
			for(Integer i : next) {
				cur.add(i);
			}
		}
		return cur;
	}
}
