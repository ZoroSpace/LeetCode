class Solution {
    public String getPermutation(int n, int k) {
        int index;
        List<Integer> nums = new ArrayList<>();
        StringBuilder result = new StringBuilder("");
        int[] fac = new int[n];
        fac[0] = 1;
        for(int i = 0;i < n;i++) nums.add(i+1);
        for(int i = 1;i < n;i++) fac[i] = i * fac[i-1];
        while(n > 0) {
            index = (k+fac[n-1]-1)/fac[n-1];
            result.append(nums.get(index-1));
            nums.remove(index-1);
            k = k - (index-1) * fac[n-1];
            n--;
        }
        return result.toString();
    }
}
