class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int days = prices.length;
        
        if(prices.length <= 1) {
            return 0;
        }
        
        // as many transaction
        if (k >=  days/2) {
            int maxProfit = 0;
            for (int i = 1; i < days; i++) {
                if (prices[i] > prices[i-1])
                    maxProfit += prices[i] - prices[i-1];
            }
            return maxProfit;
        }
        
        int[][] dp = new int[k+1][days];
        for(int i=1; i<=k; i++) {
            for(int j=1; j<days; j++) {
                int maxProfit = Integer.MIN_VALUE;
                for(int m=0; m<j; m++) {
                    int currProfit = prices[j] - prices[m] + dp[i-1][m];
                    maxProfit = Math.max(maxProfit, currProfit);
                }
                dp[i][j] = Math.max(maxProfit, dp[i][j-1]);
            }
        }
        
        return dp[k][days-1];
    }
}