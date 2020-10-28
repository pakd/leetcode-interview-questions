class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0;
        int mid = 0;
        int end = n-1;
        
        while(mid <= end) {
            if(nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, end);
                end--;   
            }
        }
    }
}