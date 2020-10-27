class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> list = new ArrayList<>();
        
        while(q.isEmpty() != true) {            
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                TreeNode temp = q.remove();
                list.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            ans.add(new ArrayList<>(list));
            list.clear();   
        }
        return ans;
    }
}