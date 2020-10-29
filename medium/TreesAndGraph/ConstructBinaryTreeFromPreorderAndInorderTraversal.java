
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTreeUtil(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode constructTreeUtil(int[] pre, int[] in, int preS, int preE, int inS, int inE) {
        
        if(preS > preE) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[preS]);
        
        int pos = -1;
        
        for(int i=inS; i<=inE; i++) {
            if(in[i] == pre[preS]) {
                pos = i;
                break;
            }
        }
        
        int inLeftStart = inS;
        int inLeftEnd = pos-1;
        
        int inRightStart = pos+1;
        int inRightEnd = inE;
        
        int preRightEnd = preE;
        int preRightStart = preRightEnd + inRightStart - inRightEnd;

        int preLeftStart = preS + 1;
        int preLeftEnd = preRightStart - 1;
        
        root.left = constructTreeUtil(pre, in, preLeftStart, preLeftEnd, inLeftStart, inLeftEnd);
        root.right = constructTreeUtil(pre, in, preRightStart, preRightEnd, inRightStart, inRightEnd);
        return root;
    }
}