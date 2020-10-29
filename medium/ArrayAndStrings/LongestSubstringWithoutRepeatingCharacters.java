class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0) return 0;
        
        Set<Character> set = new HashSet();
        Queue<Character> q = new LinkedList();
        
        int maxLength = 0;
        for(char c : s.toCharArray()) {
            
            while(set.contains(c) && !q.isEmpty()) {
                char temp = q.remove();
                set.remove(temp);
            }
            
            set.add(c);
            q.add(c);
            
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}