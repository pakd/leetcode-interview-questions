class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // counting frequency of each task
        Map<Character, Integer> map = new HashMap();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        
        // maxHeap.addAll(map.values()); -> check this line also
        for(Character x : map.keySet()) {
            maxHeap.add(map.get(x));
        }
        
        int result = 0;
        while(!maxHeap.isEmpty()) {
            int time = 0;
            List<Integer> temp = new ArrayList();
            
            // n+1 size block, exactly after n+1 index same task can come
            for(int i=0; i<n+1; i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove()-1);
                    time++;
                }
            }
            
            for(int i=0; i<temp.size(); i++) {
                if(temp.get(i) > 0) {
                    maxHeap.add(temp.get(i));
                }
            }
            
            result += maxHeap.isEmpty()? time : n+1;
        }
        
        return result;
    }
}