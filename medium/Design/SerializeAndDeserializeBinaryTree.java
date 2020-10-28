// preorder and inorder combination is not working as tree has duplicate values
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    
    public void preorder(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append(":");
            return;
        }
        str.append(root.val).append(":");
        preorder(root.left, str);
        preorder(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(":");
        Queue<String> q = new LinkedList();
        for(String s: arr) {
            q.add(s);
        }
        return deserializeUtil(q);
    }
    
    public TreeNode deserializeUtil(Queue<String> q) {
        if(q.isEmpty()) return null;
        TreeNode root = null;
        String value = q.remove();
        if(value.length() > 0) {
            root = new TreeNode(Integer.parseInt(value));
            root.left = deserializeUtil(q);
            root.right = deserializeUtil(q);
        }
        return root;
    }
}