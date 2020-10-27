class Solution {
    
    class Trie {
        public boolean isLeaf;
        Map<Character, Trie> children;
        
        Trie() {
            isLeaf = false;
            children = new HashMap<>();
        }
        
        void insert(String str) {
            Trie curr = this;
            for(char s : str.toCharArray()) {
                if(!curr.children.containsKey(s)) {
                    curr.children.put(s, new Trie());
                }
                curr = curr.children.get(s);
            }
            curr.isLeaf = true;
        }
        
        String getCommonPrefix(String anyStr) {
            Trie curr = this;
            StringBuilder sb = new StringBuilder("");

            for(char s : anyStr.toCharArray()) { 
                if(curr.children.size() > 1 || curr.isLeaf == true) {
                    return sb.toString();
                } else {
                    curr = curr.children.get(s);
                    sb.append(s);
                }
            }
            return sb.toString();
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length < 1) return "";
        if(strs.length == 1) return strs[0];
         
        Trie root = new Trie();
        for(String s : strs) {
            root.insert(s);
        }
        return root.getCommonPrefix(strs[0]);
    }
}