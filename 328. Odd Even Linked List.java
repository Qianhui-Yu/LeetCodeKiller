328. Odd Even Linked List

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        
        ListNode start = head;
        int count = 1;
        ListNode preEnd = start;
        
        while (start.next.next != null) {
            //ListNode preEnd = start;
            //for (int i = 0; i < count; i++) {
            //    preEnd = preEnd.next;
            //}
            preEnd = preEnd.next;
            
            if (preEnd == null || preEnd.next == null) break;
            
            ListNode temp = preEnd.next.next;
            preEnd.next.next = start.next;
            start.next = preEnd.next;
            preEnd.next = temp;
            
            count++;
            start = start.next;
        }
        
        return head;
    }
}