class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        // subtracting combinations
        map.put("IV", 2);
        map.put("IX", 2);
        map.put("XL", 20);
        map.put("XC", 20);
        map.put("CD", 200);
        map.put("CM", 200);
        
        
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            String temp = "" + s.charAt(i);
            ans += map.get(temp);
        }
        
        for(int i=0; i<s.length()-1; i++) {
            String temp = s.substring(i, i+2);
            if(map.containsKey(temp)) {
                ans -= map.get(temp);
            }
        }
        
        return ans;
    }
}