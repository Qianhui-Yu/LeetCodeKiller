15. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (nums[i] > 0) break;
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip same result;
            }
            
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;       // skip same result;
                    while (left < right && nums[right] == nums[right + 1]) right--;    // skip same result;
                }
                else if (nums[left] + nums[right] < target) {
                    left++;
                }
                else right--;
            }
        }
        return res;
    }
}