class Solution {
    
    class Node {
        TreeNode node;
        int state;
        Node(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList();
        if(root == null) return ans;
        
        Stack<Node> st = new Stack();
        
        st.push(new Node(root, 0));
        
        while(!st.isEmpty()) {
            
            Node top = st.pop();
                
            if(top.node == null || top.state == 3) continue;
            
            st.push(new Node(top.node, top.state + 1));
            
            if(top.state  == 0) {
                st.push(new Node(top.node.left, 0));
            } else if(top.state == 1) {
                ans.add(top.node.val);
            } else if(top.state == 2) {
                st.push(new Node(top.node.right, 0));
            }
            
        }
        
        return ans;
    }
}