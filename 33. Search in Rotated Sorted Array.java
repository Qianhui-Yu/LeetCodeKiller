class Solution {
    public int search(int[] nums, int target) {
        int s = nums.length;
        if(s == 0) return -1;
        int minIndex = findMinIndex(nums);
        if (nums[minIndex] == target) return minIndex;
        if (target < nums[minIndex]) return -1;
        // 选段 
        /* 
        // 这种方式编译会不通过，会使start，end没有被初始化
        if (target <= nums[s - 1]) {
            int start = minIndex;
            int end = s - 1;
        } 
        else {
            int start = 0;
            int end = minIndex - 1;
        }*/
        int start = (target <= nums[s - 1])? minIndex: 0;
        int end = (target > nums[s - 1])? minIndex - 1: s - 1;
        
        // 这里用<=是因为考虑到最后会聚焦到一个元素上判断是否为target
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        
        return -1;
    }
     private static int findMinIndex(int[] nums) {
         int start = 0;
         int end = nums.length - 1;
         
         while(start < end) {
             int mid = start + (end - start) / 2;
             if (nums[mid] > nums[end]) start = mid + 1;
             else end = mid;
         }
         
         return start;
     }
}