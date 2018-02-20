class Solution {
    int total;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        total = n1+n2;
        if(n1 == 0 && n2 == 0) return 0;
        if(n1 == 0) return mid(nums2,0,n2-1);
        if(n2 == 0) return mid(nums1,0,n1-1);
        return helper(nums1,0,n1-1,nums2,0,n2-1,0);
    }
    
    double helper(int[] nums1,int lo1,int hi1,int[] nums2,int lo2,int hi2,int pre) {
        if(hi1-lo1 <= 2 && hi2 - lo2 <= 2) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = lo1;i <= hi1;i++) list.add(nums1[i]);
            for(int i = lo2;i <= hi2;i++) list.add(nums2[i]);
            Collections.sort(list);
            if(total % 2 != 0) {
                return list.get((total+1)/2-pre-1);
            } else {
                return ((double)(list.get(total/2-pre-1)+list.get(total/2-pre)))/2;
            }
        }
        if(mid(nums1,lo1,hi1) > mid(nums2,lo2,hi2)) {
            if(lo1!=hi1) return helper(nums1,lo1,(lo1+hi1)/2+1,nums2,(lo2+hi2)/2,hi2,pre+(lo2+hi2)/2-lo2);
            else return helper(nums1,lo1,hi1,nums2,(lo2+hi2)/2,hi2,pre+(lo2+hi2)/2-lo2);
        } else {
            if(lo2!=hi2) return helper(nums1,(lo1+hi1)/2,hi1,nums2,lo2,(lo2+hi2)/2+1,pre+(lo1+hi1)/2-lo1);
            else return helper(nums1,(lo1+hi1)/2,hi1,nums2,lo2,hi2,pre+(lo1+hi1)/2-lo1);
        }
    }
    
    double mid(int[] nums,int lo,int hi) {
        if((hi+lo) % 2 == 0) return nums[(lo+hi)/2];
        else return (nums[(lo+hi)/2] + nums[(lo+hi)/2+1])/2;
    }
}
