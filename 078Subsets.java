class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> elem = new LinkedList<>();
		if(nums.length == 0) {
			result.add(elem);
			return result;
		}
		if(nums.length == 1) {
			result.add(new LinkedList<>());
			elem.add(nums[0]);
			result.add(elem);
			return result;
		}
		int[] sNums = new int[nums.length-1];
		System.arraycopy(nums,0,sNums,0,sNums.length);
		for(List p : subsets(sNums)) {
			result.add(p);
			LinkedList q = (LinkedList)((LinkedList)p).clone();
				q.add(nums[nums.length-1]);
				result.add(q);
		}
		return result;
	}
}
