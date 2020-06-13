380. Insert Delete GetRandom O(1)

class RandomizedSet {
    // number - index
    Map<Integer, Integer> map;
    List<Integer> nums;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int loc = map.get(val);
            if (loc != nums.size() - 1) {
                int last = nums.get(nums.size() - 1);
                nums.set(loc, last);
                map.put(last, loc);
            }
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size()));
    }
}