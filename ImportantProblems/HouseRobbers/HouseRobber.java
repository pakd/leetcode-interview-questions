class Solution {
    public int rob(int[] nums) {
        
        // sanity check 
        if(nums.length == 0) {
            return 0;
        }
        
        int prevRobbed = nums[0];
        int prevNotRobbed = 0;
        
        for(int i=1; i<nums.length; i++) {
            int temp = prevRobbed;            
            prevRobbed = prevNotRobbed + nums[i];
            prevNotRobbed = Math.max(temp, prevNotRobbed);
        }
        
        return Math.max(prevNotRobbed, prevRobbed);
    }
}