209. Minimum Size Subarray Sum

1. two pointers
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // two pointers
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        while (start < nums.length && end < nums.length) {
            sum += nums[end++];
            while (sum >= s) {
                res = Math.min(res, end - start);
                sum -= nums[start];
                start++;
            }
        }
        
        return (res == Integer.MAX_VALUE)? 0: res;
    }
}

2. binary search
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] += nums[i] + sums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sums[i+1] >= s) {
                int start = bs(sums, 0, i+1, sums[i+1] - s);
                res = Math.min(res, i - start + 1);
            }
        }
        
        return (res == Integer.MAX_VALUE)? 0: res;
    }
    
    public int bs(int[] sums, int start, int end, int k) {
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (sums[mid] <= k) {
                if (sums[mid+1] > k) return mid;
                else start = mid + 1;
            }
            else end = mid - 1;
        }
        return start;
    }
}