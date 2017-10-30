class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        else {
            int[] minNum = new int[prices.length];
            minNum[0] = prices[0];
            int result = 0;

            for(int i = 0;i < prices.length - 1;i++) {
                if(minNum[i] < prices[i+1]) {
                    minNum[i+1] = minNum[i];

                } else {
                    minNum[i+1] = prices[i+1];
                }
                result = result > prices[i+1]-minNum[i+1]?result:prices[i+1]-minNum[i+1];
            }
            return result;
        }
        
    }
}
