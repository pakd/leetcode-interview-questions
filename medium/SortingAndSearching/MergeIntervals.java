class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> list = Arrays.asList(intervals);
        
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        List<int[]> merged = new ArrayList();
        
        for(int i=0; i<list.size(); i++) {
            if(merged.size() == 0) {
                merged.add(list.get(i));
                continue;
            }
            
            if(merged.get(merged.size()-1)[1] < list.get(i)[0]) {
                merged.add(list.get(i));
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], list.get(i)[1]);
            }

        }
        
        int[][] ans = new int[merged.size()][2];
        
        for(int i=0; i<merged.size(); i++) {
            ans[i][0] = merged.get(i)[0];
            ans[i][1] = merged.get(i)[1];
        }
        
        return ans;
        
    }
}