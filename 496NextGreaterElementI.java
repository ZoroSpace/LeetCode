class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int[] result = new int[a];
        for(int i = 0;i < a;i++) {
            result[i] = -1;
            for(int j = 0;j<b;j++) {
                if(nums1[i] == nums2[j]) {
                    for(int k = j++;k<b;k++) {
                        if(nums1[i] < nums2[k]) {
                            result[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
}
