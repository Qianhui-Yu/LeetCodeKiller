88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int end = m + n - 1;
        
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[end--] = (nums1[tail1] > nums2[tail2])? nums1[tail1--]: nums2[tail2--];
        }
        
        // 此时要么是tail1<0 要么是 tail2<0, 如果tail2 < 0 其实已经merge完成，结束
        // 但如果是tail1<0 merge未完成 比如[0,0,0,0] [1,2,3]这种情况 
        while (tail2 >= 0) {
            nums1[end--] = nums2[tail2--];
        }
    }
}