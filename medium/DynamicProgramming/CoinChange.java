class Solution {
    
    // simple greedy approach will not work
    public int coinChange(int[] coins, int amount) {
        
        // sanity checks
        if(coins.length == 0 || amount == 0) return 0;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for( int i=0; i<=amount; i++) {
            for(int j=0; j<coins.length; j++) {
                if(i >= coins[j]) {
                    if(dp[i - coins[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    }
                }
            }
        }
        
        return (dp[amount] != Integer.MAX_VALUE)? dp[amount] : -1;
    }
}