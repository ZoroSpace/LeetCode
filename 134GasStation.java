class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n == 0) return -1;
        int[] dp = new int[n];
        for(int i = 0;i < n;i++) {
            dp[i] = gas[i] - cost[i];
        }
        int left = n/2,right = n/2+1;
        while(true) {
            while(dp[right] >= 0) {
                right = (right+1+n)%n;
                dp[right] = dp[right] + dp[(right-1+n)%n];
            }
            dp[right]  = dp[right] + dp[left];
            if(left == (right+1+n) % n) {
                if(dp[left] >= 0) return left;
                else return -1;
            }
            left = (left-1+n)%n;
        }
    }
}
