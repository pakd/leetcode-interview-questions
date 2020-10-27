class Solution {
    
    List<Integer> list = new LinkedList<>();
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
}