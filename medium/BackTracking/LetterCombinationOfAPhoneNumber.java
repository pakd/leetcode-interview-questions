class Solution {
    public HashMap<Character, String> map = new HashMap<Character, String>();
    
    public void letterCombinationsUtil(List<String> ans, StringBuilder curr, int i, String digits, Map<Character, String> map) {
        if(curr.length() == digits.length()) {
            ans.add(curr.toString());
            return;
        }
        
        String temp = map.get(digits.charAt(i));
        int len = temp.length();
        
        for(int j=0; j<len; j++) {
            // choose
            curr.append(temp.charAt(j));
            
            //explore
            letterCombinationsUtil(ans, curr, i+1, digits, map);
            
            // unchoose
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList();
        Map<Character, String> map = new HashMap();
        
        int n = digits.length();
        if(n==0) return ans;
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuilder sb = new StringBuilder();
        
        letterCombinationsUtil(ans, sb, 0, digits, map);
        
        return ans;
    }
}