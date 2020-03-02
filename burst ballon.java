public int maxCoins(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    return maxCoins(nums, 0, nums.length - 1, dp);
}

public int maxCoins(int[] nums, int start, int end, int[][] dp) {
    if (start > end) {
        return 0;
    }
    if (dp[start][end] != 0) {
        return dp[start][end];
    }
    int max = nums[start];
    for (int i = start; i <= end; i++) {
        int val = maxCoins(nums, start, i - 1, dp) + 
                  get(nums, i) * get(nums, start - 1) * get(nums, end + 1) + 
                  maxCoins(nums, i + 1, end, dp);
                  
        max = Math.max(max, val);
    }
    dp[start][end] = max;
    return max;
}

public int get(int[] nums, int i) {
    if (i == -1 || i == nums.length) {
        return 1;
    }
    return nums[i];
}