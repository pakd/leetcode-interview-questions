public class Solution {
    
    class Node {
        int val;
        char type;
        Node(int val, char type) {
            this.val = val;
            this.type = type;
        }
    }
    
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        List<Node> list = new ArrayList();
        
        for(int i=0; i<A.size(); i++) {
            list.add(new Node(A.get(i).get(0), 'a'));
            list.add(new Node(A.get(i).get(1), 'd'));
        }
        
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if(a.val == b.val) {
                    // if both equal then departure should come first
                    return (a.type == 'd')? -1: 1;
                }
                return a.val - b.val;
            }
        });
        
        int maxRooms = 0;
        int currRooms = 0;
        for(int i=0; i<list.size(); i++) {
            currRooms += (list.get(i).type == 'a')? 1 : -1;
            maxRooms = Math.max(maxRooms, currRooms);
        }
        
        return maxRooms;
    }
}