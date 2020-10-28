class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    int pivot(int[] nums, int low, int high) {
        int key = nums[high];
        int pos = low-1;
        for(int i=low; i<high; i++) {
            if(nums[i] <= key) {
                pos++;
                swap(nums, i, pos);
            }
        }
        swap(nums, pos+1, high);
        return pos+1;
    }
    
    int findKthSmallest(int[] nums, int low, int high, int k) {
        int p = pivot(nums, low, high);
        if ( (p - low ) == (k - 1) ) {
            return nums[p];
        } else if ((p - low) > (k-1)){
            return findKthSmallest(nums, low, p-1, k);
        } else {
            return findKthSmallest(nums, p+1, high, (k - 1) - (p - low));
        }
    }
    
    
    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        // converted the problem to kth smallest
        k = n - k + 1;
        return findKthSmallest(nums, 0, n-1, k);
    }
}