class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        LinkedList<Integer> list = new LinkedList<>();
        int first = 0,second = 0;
        while(first < nums1.length && second < nums2.length) {
            if(nums1[first] < nums2[second]) first++;
            else if (nums1[first] > nums2[second]) second++;
            else {
                list.add(nums1[first]);
                second++;
                while(second < nums2.length && nums1[first] == nums2[second]) second++;
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
