/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        head = dummy;
        for (int i = 0; i <n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return dummy.next;
            }
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        head.next = head.next.next;
        
        return dummy.next;
        
    }
}