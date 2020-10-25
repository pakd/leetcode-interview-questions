/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    
    class Pair {
        int rob;
        int notRob;
        Pair(int rob, int notRob) {
            this.rob = rob;
            this.notRob = notRob;
        }
    }
    
    public int rob(TreeNode root) {
        Pair p = robUtil(root);
        return Math.max(p.rob, p.notRob);
    }
    
    
    public Pair robUtil(TreeNode root) {
        
        if(root == null) {
            return new Pair(0, 0);
        }
        
        Pair left = robUtil(root.left);
        Pair right = robUtil(root.right);
        
        int currRob = root.val + left.notRob + right.notRob;
        
        // all 4 posibilities
        int currNotRob = Math.max(left.notRob + right.notRob,
                         Math.max(left.notRob + right.rob,
                         Math.max( left.rob + right.rob, left.rob + right.notRob)));
        
        return new Pair(currRob, currNotRob);
        
    }
}