206. Reverse Linked List

1. iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        //if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}

2. recursive
class Solution {
    public ListNode reverseList(ListNode head) {
         return reverse(head, null);
    }
    
    public ListNode reverse(ListNode head, ListNode pre) {
        if (head == null) return pre;
        ListNode next = head.next;
        head.next = pre;
        return reverse(next, head);
    }
}