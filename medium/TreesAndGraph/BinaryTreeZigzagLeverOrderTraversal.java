class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList();
            
            if(!stack1.isEmpty()) {
                while(!stack1.isEmpty()) {
                    TreeNode top = stack1.pop();
                    if(top.left != null) {
                        stack2.push(top.left);
                    }
                    if(top.right != null) {
                        stack2.push(top.right);
                    }
                    list.add(top.val);
                }
                ans.add(list);
                continue;
            }
            if(!stack2.isEmpty()) {
                while(!stack2.isEmpty()) {
                    TreeNode top = stack2.pop();
                    if(top.right != null) {
                        stack1.push(top.right);
                    }
                    if(top.left != null) {
                        stack1.push(top.left);
                    }
                    list.add(top.val);
                }
                ans.add(list);
                continue;
            }
        }
        
        return ans;
    }
}