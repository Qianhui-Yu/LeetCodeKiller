540. Single Element in a Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0)
                    end = mid - 2;
                else start = mid + 1;
            }
            else {
                if ((end - mid) % 2 == 0)
                    start = mid + 2;
                else
                    end = mid - 1;
            }
        }
        
        return nums[start];
    }
}