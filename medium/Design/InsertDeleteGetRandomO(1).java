class RandomizedSet {
    
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        list.add(val);
        map.put(val, list.size()-1);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val)) return false;
        
        int index = map.get(val);   // <val -> index >
        int toPut = list.get(list.size()-1); // < temp -> list.size()-1 >
        
        list.set(index, toPut);
        list.remove(list.size()-1);
        map.put(toPut, index);
        map.remove(val);

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}