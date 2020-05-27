525. Contiguous Array

class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        // count-index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0)? -1: 1;
            if (map.containsKey(count)) {
                res = Math.max(res, i - map.get(count));
            }
            else {
                map.put(count, i);
            }
        }
        
        return res;
    }
}