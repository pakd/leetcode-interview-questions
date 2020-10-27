class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int maxSoFar = nums[0];
        
        for(int i=1; i<n; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        
        return maxSoFar;
    }
}