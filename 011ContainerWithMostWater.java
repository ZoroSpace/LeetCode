class Solution {
    public int maxArea(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i < nums.length;i++) {
            map.put(nums[i],i);
        }
        Integer integ;
        int ai;
        int left = 0;
        int right = nums.length-1;
        int result = 0;
        Iterator iter = map.entrySet().iterator();
        int[] flag = new int[nums.length];
        int[] c = new int[nums.length];
        int i = 0;
        
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            ai = (Integer)entry.getKey();
            integ = (Integer)entry.getValue();
            result = Math.max(result,ai*(integ-left));
            result = Math.max(result,ai*(right-integ));
            flag[integ] = 1;
            while(flag[left] == 1) left++;
            while(flag[right] == 1) right--;
            if(left == right) break;
        }
        return c[0];
    }
}
