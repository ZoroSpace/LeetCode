class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        int first = 0;
        int second = 0;
        while((first < nums1.size()) && (second < nums2.size())) {
            if(nums1[first] < nums2[second]) {
                first++;
            } else if(nums1[first] > nums2[second]) {
                second++;
            } else {
                ans.push_back(nums1[first]);
                second++;
                while((second < nums2.size()) && (nums2[second] == nums2[second-1])) second++;
            }
        }
        return ans;
    }
};


class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        int first = 0;
        int second = 0;
        while((first < nums1.end()-nums1.begin()) && (second < nums2.end()-nums2.begin())) {
            if(nums1.at(first) < nums2.at(second)) {
                first++;
            } else if(nums1.at(first) > nums2.at(second)) {
                second++;
            } else {
                ans.push_back(nums1.at(first));
                second++;
                while((second < nums2.end()-nums2.begin()) && (nums2.at(second) == nums2.at(second-1))) second++;
            }
        }
        return ans;
    }
};


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
