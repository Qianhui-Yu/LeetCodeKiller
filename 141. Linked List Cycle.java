public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) return true;
            else set.add(cur);
            cur = cur.next;
        }
        
        return false;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        
        return false;
    }
}