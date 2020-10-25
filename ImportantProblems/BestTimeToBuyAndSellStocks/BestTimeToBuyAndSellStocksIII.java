class Solution {
    public int maxProfit(int[] prices) {
        
        int days = prices.length;
        
        // sanity check
        if(prices.length < 2) {
            return 0;
        }
        
        int[] profit1 = new int[days];
        Arrays.fill(profit1, 0);
        
        int[] profit2 = new int[days];
        Arrays.fill(profit2, 0);
        
        // first profit
        int min = prices[0];
        for(int i=1; i<days; i++) {
            profit1[i] = Math.max(prices[i] - min, profit1[i-1]);
            min = Math.min(min, prices[i]);
        }
        
        // second profit
        int max = prices[days-1];
        for(int i=days-2; i>=0; i--) {
            profit2[i] = Math.max(max - prices[i], profit2[i+1]);
            max = Math.max(max, prices[i]);
        }
        
        // total profit
        int maxProfit = 0;
        for(int i=0; i<days; i++) {
            maxProfit = Math.max(maxProfit, profit1[i] + profit2[i]);
        }
        
        return maxProfit;
    }
}