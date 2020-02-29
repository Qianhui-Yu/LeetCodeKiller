class Solution {
    public int maxSubArray(int[] nums) {
        // DP
        // f[i] = f[i-1] > 0? f[i-1] + nums[i]: nums[i]
        //     [-2,1,-3,4,-1,2,1,-5,4]
        // f[]:[-2,1,-2,(4,3,5,6),1,5] 
        // f[i] 表示 maxSubArray(0:i), 所以如果前一个状态能取的max为正，那么当前状态应该是上一个状态加当前元素，
        // 如果上一个状态是负，那么当前能取的最大值就是本事，不然加负越小
        // 用数组记录的话，还可以找到是哪个subarray，从max=6往前找到最前不为负的值就是起点，因为碰到sum为负会清空从自身开始subarray
        
        // 存储空间优化至O(1)
        // 因为发现f[i]只与上一个状态相关，所以可以用一个变量来代替
        // 但这样找不到subarray的位置
        int sum = nums[0];
        int max = sum;
        
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        
        return max;
    }
}