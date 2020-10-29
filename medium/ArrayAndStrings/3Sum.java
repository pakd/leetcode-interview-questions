class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // time limit exceeds , so used set instead
        List<List<Integer>> ans = new ArrayList();
        Set<List<Integer>> set = new HashSet();
        
        int n = nums.length;
        if (n < 3) return ans;
        
        Arrays.sort(nums); 
        
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }
        }

        return new ArrayList(set);
    }
}