class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;
     
        Map<Character, Integer> map = new HashMap<>();   
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for(char x : t.toCharArray()) {
            if(map.containsKey(x) && map.get(x) > 0) map.put(x, map.get(x)-1);
            else return false;
        }
        
        for(Character x : map.keySet()) {
            if(map.get(x) != 0) return false;
        }
        return true;
    }
}