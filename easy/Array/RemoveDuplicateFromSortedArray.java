class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        int index = 1;
        
        for(int i=0; i<n-1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[index] = nums[i+1];
                index++;
            }
        }
        
        return index;
    }
}