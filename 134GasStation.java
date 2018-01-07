class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length,start = 0,end;
        int[] dp = new int[n];
        for(int i = 0;i < n;i++) dp[i] = gas[i] - cost[i];
        if(n == 0) return -1;
        for(int i = 0;i < n; i++) {
            if(dp[i] >= 0) {
                start = i;
                break;
            }
        }
        if(dp[start] < 0) return -1;
        end = (start+1+n)%n;
        dp[end] = dp[end] + dp[start];
        while(start != end) {
            if(dp[end] >= 0) {
                end = (end+1+n)%n;
                dp[end] = dp[end] + dp[(end-1+n)%n];
            } else {
                start = (start-1+n)%n;
                dp[end] = dp[end] + dp[start];
            }
        }
        if(dp[start] >= 0) return start;
        else return -1;
    }
}
