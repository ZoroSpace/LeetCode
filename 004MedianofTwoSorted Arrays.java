class Solution {
    int total;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        total = n1+n2;
        //若nums1或nums2是空
        if(n1 == 0 && n2 == 0) return 0;
        if(n1 == 0) return mid(nums2,0,n2-1);
        if(n2 == 0) return mid(nums1,0,n1-1);
        return helper(nums1,0,n1-1,nums2,0,n2-1,0);
    }
    
    double helper(int[] nums1,int lo1,int hi1,int[] nums2,int lo2,int hi2,int pre) {
        if(total % 2 != 0 && total/2 == pre) {
            return Math.min(nums1[lo1],nums2[lo2]);
        }
        if(total % 2 == 0 && total/2-1 == pre) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = lo1;i <= hi1;i++) list.add(nums1[i]);
            for(int i = lo2;i <= hi2;i++) list.add(nums2[i]);
            Collections.sort(list);
            return ((double)(list.get(0)+list.get(1)))/2;
        }
        if(mid(nums1,lo1,hi1) > mid(nums2,lo2,hi2)) {
            return helper(nums1,lo1,hi1,nums2,(lo2+hi2)/2,hi2,pre+(lo2+hi2)/2-lo2);
        } else {
            return helper(nums1,(lo1+hi1)/2,hi1,nums2,lo2,hi2,pre+(lo1+hi1)/2-lo1);
        }
    }
    
    double mid(int[] nums,int lo,int hi) {
        //如果奇数个
        if((hi+lo) % 2 == 0) return nums[(lo+hi)/2];
        //如果偶数个
        else return (nums[(lo+hi)/2] + nums[(lo+hi)/2+1])/2;
    }
}
