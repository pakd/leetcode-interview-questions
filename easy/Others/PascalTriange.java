class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        if(numRows == 0) return triangle;
        
        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);
        
        if(numRows == 1) return triangle;
        
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        triangle.add(second);
        
        if(numRows == 2) return triangle;
        
        for(int i=2; i<numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            List<Integer> previousRow = triangle.get(i-1);
            
            newList.add(1);
            
            for(int j=0; j<previousRow.size()-1; j++) {
                newList.add(previousRow.get(j) + previousRow.get(j+1));
            }
            
            newList.add(1);
            
            triangle.add(newList);
        }
        
        return triangle;
    }
}