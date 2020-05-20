75. Sort Colors

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        
        int low = 0;
        int high = nums.length - 1;
        
        for(int i = 0; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                low++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
                //换过来的可能还是2 所以i不递增
            }
            else i++;
        }
        
        return;
    }
    
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
        return;
    }
} 