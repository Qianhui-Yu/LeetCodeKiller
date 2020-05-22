21. Merge Two Sorted Lists

1. iterative
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        ListNode head1 = l1;
        ListNode head2 = l2;
        
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            }
            else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        
        cur.next = (head1 == null)? head2: head1;
        
        return res.next;
    }
}

2. recursion
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // recursive
        // stop
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // recursion
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}