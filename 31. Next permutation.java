class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        
        // Find the largest index i of element that break the descending order
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) 
                break;
        }
        
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // Find the largest index j(j > i) of element that greater than element i
        int j;
        for (j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i]) 
                break;
        }
        
        swap(nums, i, j);
        reverse(nums, i+1, nums.length - 1);
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void reverse(int[] nums, int i, int j) {
        for (int s = i; s <= i + (j - i) / 2; s++) {
            swap(nums, s, i+j-s);
        }
    }
}