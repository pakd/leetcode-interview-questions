class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int x : nums1) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int x : nums2) {
            if(map.containsKey(x) && map.get(x) > 0) {
                map.put(x, map.get(x)-1);
                list.add(x);
            }
        }
        
        int[] ret = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
}