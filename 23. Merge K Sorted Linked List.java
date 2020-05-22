23. Merge K Sorted Linked List

1. priorityQueue

2. divide conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = divideConquer(lists, 0, lists.length - 1);
        return res;
    }
    
    public ListNode divideConquer(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        
        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode left = divideConquer(lists, start, mid);
            ListNode right = divideConquer(lists, mid + 1, end);
            return merge(left, right);
        }
        return null; // case: lists == null;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}