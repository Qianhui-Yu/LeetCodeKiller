325. Maximum Size Subarray Sum Equals k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        // sum - index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
        }
        
        return res;
    }
}