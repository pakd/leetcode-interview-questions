class Solution {
    int k;
    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null || arr.size() == k) return;
        inorder(root.left, arr);
      
        arr.add(root.val);
        if(arr.size() == k) return;
        inorder(root.right, arr);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        this.k = k;
        List<Integer> list = new ArrayList();
        inorder(root, list);
        return list.get(k - 1);
    }
}