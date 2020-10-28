class Solution {
    
    public int bsExtremeLeft(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int index = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                index = mid;
                high = mid-1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else if(nums[mid] < target){
                low = mid+1;
            }
        }
        
        return index;
    }
    
    public int bsExtremeRight(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        int index = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                index = mid;
                low = mid+1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else if(nums[mid] < target){
                low = mid+1;
            }
        }
        
        return index;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        
        ans[0] = bsExtremeLeft(nums, target);
        ans[1] = bsExtremeRight(nums, target);
        
        return ans;
    }

}