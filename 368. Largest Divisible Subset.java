368. Largest Divisible Subset

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        int index = -1;
        int max = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (index >= 0) {
            res.add(nums[index]);
            index = prev[index];
        }
        
        return res;
    }
}