public class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();
    
    public RandomizedSet() {
        // do intialization if necessary
        dict = new HashMap();
        list = new ArrayList<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (dict.containsKey(val)) return false;
        
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!dict.containsKey(val)) return false;
        int last = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, last);
        dict.put(last, idx);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */