/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public TreeNode findNode(TreeNode root, int key) {
        if(root == null || root.val == key ) return root;

        if (root.val > key)  {
            return findNode(root.left, key);
        } else {
            return findNode(root.right, key);
        }
    }
    
    public TreeNode findMinNode(TreeNode root) {
        if(root == null) return root;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    
    public TreeNode getSuccessor(TreeNode a, int b) {
        
        if(a == null) return null;
        
        TreeNode curr = findNode(a, b);
        if(curr == null) return curr;
        
        // if node has right subtree
        if(curr.right != null) {
            return findMinNode(curr.right);
        } else { // no right subtree
            
            TreeNode iter = a;
            TreeNode sucessor = null;
            while(iter != curr) {
                if(iter.val > b) {
                    sucessor = iter;
                    iter = iter.left;
                } else {
                    iter = iter.right;
                }
            }
            return sucessor;
        }

    }
}



