class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length-1);
    }
    
    public int bs(int[] nums, int target, int low , int high) {
        if(low > high) return -1;
        
        int mid = low + (high-low)/2;
        
        if(nums[mid] == target) return mid;
        
        // if left part is sorted
        if(nums[low] <= nums[mid]) {
            //if target is in first half
            if(nums[low] <= target && target <= nums[mid]) {
                return bs(nums, target, low, mid-1);
            }
            return bs(nums, target, mid+1, high);
        } else {
            if(nums[mid] <= target && target <= nums[high]) {
                return bs(nums, target, mid+1, high);
            }
            return bs(nums, target, low, mid-1);
        }
    }
}