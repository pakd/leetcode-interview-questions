class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        
        int N = nums.length;
        int size = (int)Math.pow(2, N);
        
        for(int i=0; i< size; i++) {
            List<Integer> list = new ArrayList();
            for(int j=0; j<N; j++) {
                if ( (i & (1 << j)) != 0 ) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}