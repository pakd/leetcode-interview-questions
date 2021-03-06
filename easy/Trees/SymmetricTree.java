class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricUtil(root.left, root.right);
    }
    
    public boolean isSymmetricUtil(TreeNode A, TreeNode B) {
        if(A == null && B == null) return true;
        else if(A == null || B == null) return false;
        return (A.val == B.val && isSymmetricUtil(A.left, B.right) && isSymmetricUtil(A.right, B.left));    
    }
}
// for iterative, use inorder then verify if palindrome