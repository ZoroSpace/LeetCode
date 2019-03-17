class NumArray {
public:
    vector<int> table;
    NumArray(vector<int> nums) {
        
        int n = nums.size();
        table.resize(n+1);
        for(int i = 1;i <= n;i++) {
            table[i] = table[i-1] + nums[i-1];
        }
    }
    
    int sumRange(int i, int j) {
        return table[j+1] - table[i];
    }
};

class NumArray {
public:
    int *table;
    NumArray(vector<int> nums) {
        int n = nums.size();
        table = new int[n+1]();
        for(int i = 1;i <= n;i++) {
            table[i] = table[i-1] + nums[i-1];
        }
    }
    
    int sumRange(int i, int j) {
        return table[j+1] - table[i];
    }
};


class NumArray {
    
    int[] table;

    public NumArray(int[] nums) {
        int n = nums.length;
        table = new int[n+1];
        for(int i = 1;i < n+1;i++) {
            table[i] = table[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return table[j+1] - table[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
