class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();//map1:lo->hi
        HashMap<Integer,Integer> map2 = new HashMap<>();//map2:hi->lo
        int hi,lo;
        for(int i = 0;i < nums.length;i++) {
            if(map1.containsKey(nums[i]+1) && map1.containsValue(nums[i]-1)) {
                hi = map1.get(nums[i]+1);
                lo = map2.get(nums[i]-1);
                map1.remove(nums[i]+1);
                map1.put(lo,hi);
                map2.remove(nums[i]-1);
                map2.put(hi,lo);
            } else if(map1.containsKey(nums[i]+1)) {
                hi = map1.get(nums[i]+1);
                lo = nums[i];
                map1.remove(nums[i]+1);
                map1.put(lo,hi);
                map2.put(hi,lo);
            } else if(map1.containsValue(nums[i]-1)) {
                hi = nums[i];
                lo = map2.get(nums[i]-1);
                map1.put(lo,hi);
                map2.remove(nums[i]-1);
                map2.put(hi,lo);
            } else if(map1.containsKey(nums[i])||map1.containsValue(nums[i])) {
                continue;
            } else {
                map1.put(nums[i],nums[i]);
                map2.put(nums[i],nums[i]);
            }
        }
        int result = 0;
        for(int i : map1.keySet()) {
            result = Math.max(result,map1.get(i)-i+1);
        }
        return result;
    }
}
