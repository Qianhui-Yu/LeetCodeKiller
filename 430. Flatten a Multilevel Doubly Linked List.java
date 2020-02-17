/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        //if (head == null) return null;
        
        Node cur = head;
        while (cur != null) {
            if (cur.child == null) {
                cur = cur.next;
            }
            else {
                Node temp = cur.child;
                // find tail
                //先找尾巴连尾巴再连前面的child，这是Linked List的特性，因为如果先搞前面后面的信息会丢失
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = cur.next;
                // 注意cur.next = null的情形，不需要prev
                if (cur.next != null) temp.next.prev = temp;
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = cur.next;
            }
        }
        
        return head;
        
    }
}