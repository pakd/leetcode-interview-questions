class Solution {
    public Node connect(Node root) {
        
        if( root == null) return null;
        
        Queue<Node> q = new LinkedList();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()) {
            
            Node front = q.remove();
            
            if(front != null) {
                front.next = q.peek();
                
                if(front.left != null) {
                    q.add(front.left);
                }
                if(front.right != null) {
                    q.add(front.right);
                }
                
            } else{
                if(!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        
        return root;    
    }
}