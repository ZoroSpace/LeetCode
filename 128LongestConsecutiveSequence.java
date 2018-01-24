class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map1 = new HashMap<>();//map1:lo->hi
        HashMap<Integer,Integer> map2 = new HashMap<>();//map2:hi->lo
        HashSet<Integer> visited = new HashSet<>();
        int hi,lo,result = 0;
        for(int i : nums) {
            if(!visited.contains(i)) {
                lo = map2.containsKey(i-1) ? map2.get(i-1) : i;
                hi = map1.containsKey(i+1) ? map1.get(i+1) : i;
                visited.add(i);
                map1.put(lo,hi);
                map2.put(hi,lo);
                result = Math.max(result,hi-lo+1);
            } 
        }
        return result;
    }
}
