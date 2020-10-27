class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTreeUtil(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildTreeUtil(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }
        
        int mid = low + (high-low)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTreeUtil(nums, low, mid-1);
        root.right = buildTreeUtil(nums, mid+1, high);
        return root;
    }
}