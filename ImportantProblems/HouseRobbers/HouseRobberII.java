class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        // sanity checks
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        // rob(nums, 0, n-2) : not including last element
        // rob(nums, 1, n-1) : not including first element
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }
    
    public int rob(int[] nums, int start, int end) {

        int prevRobbed = nums[start];
		int prevNotRobbed = 0;
		
		for(int i=start+1; i<=end; i++) {
			int temp = prevRobbed;            
			prevRobbed = prevNotRobbed + nums[i];
            prevNotRobbed = Math.max(temp, prevNotRobbed);
		}
		
		return Math.max(prevNotRobbed, prevRobbed);
    }
    
}