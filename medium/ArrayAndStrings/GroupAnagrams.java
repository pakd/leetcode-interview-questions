class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap();
        
        for(int i=0; i<strs.length; i++) {
            char[] copy = strs[i].toCharArray();
            
            Arrays.sort(copy);
            String s = new String(copy);
            
            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }
        
        for(String x : map.keySet()) {
            ans.add(map.get(x));
        }
        
        return ans;
    }
}