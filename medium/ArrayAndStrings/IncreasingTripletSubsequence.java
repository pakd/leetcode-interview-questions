class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        if(nums.length < 3) return false;
        
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
              
        // equal to bcz small can not be treated as big
        for(int x : nums) {
            if(x <= small) {
                small = x;
            } else if(x <= big) {
                big = x;
            } else {
                return true;
            }
        }
        return false;
    }
}