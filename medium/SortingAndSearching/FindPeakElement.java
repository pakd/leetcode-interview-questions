class Solution {
    
    public int bs(int[] nums, int low, int high) {
        if(low > high) return -1;
        
        int mid = low + (high - low)/2;
        
        if ( ( mid == 0 || nums[mid-1] < nums[mid] ) && ( mid == nums.length-1 || nums[mid] > nums[mid+1] ))  {
            return mid;
        } else if( mid+1 < nums.length && nums[mid] < nums[mid+1]) {
            return bs(nums, mid+1, high);
        } else {
            return bs(nums, low, mid-1);
        }
    }
    
    public int findPeakElement(int[] nums) {
        return bs(nums, 0, nums.length-1);
    }
}