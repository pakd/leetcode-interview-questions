class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList();
        
        List<Integer> suffix = new ArrayList();
        for(int x : nums) suffix.add(x);
        
        permuteUtil(ans, suffix, new ArrayList<Integer>(), nums.length);
        
        return ans;
    }
    
    public void permuteUtil(List<List<Integer>> ans, List<Integer> suffix, List<Integer> prefix, int n) {
        
        if(prefix.size() == n) {
            ans.add(new ArrayList(prefix));
            return;
        }
        
        for(int i=0; i<suffix.size(); i++) {
            
            // choose
            prefix.add(suffix.get(i));
            List<Integer> suffixCopy = new ArrayList(suffix);
            suffixCopy.remove(i);
            
            // explore
            permuteUtil(ans, suffixCopy, prefix, n);
            
            // unchoose
            prefix.remove(prefix.size()-1); 
        }
    }
}