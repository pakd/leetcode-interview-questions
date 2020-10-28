class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        
        for(int x  nums) {
            
            if(count == 0) {
                candidate = x;
                count = 1;
            } else {
                count += (candidate == x) 1  -1; 
            }
        }
        
        return candidate;
    }
}