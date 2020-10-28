class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1 );
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( (a,b) -> map.get(a) - map.get(b));
        
        for(Integer x : map.keySet()) {
            minHeap.add(x);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        int[] ans = new int[k];
        int i = k-1;
        while(!minHeap.isEmpty() && i >= 0) {
            ans[i] = minHeap.remove();
            i--;
        }
        
        return ans;
    }
}