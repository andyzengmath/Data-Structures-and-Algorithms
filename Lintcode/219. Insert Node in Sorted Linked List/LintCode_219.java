public class LintCode_219 {
    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy
        
        while (cur.next != null && cur.next.val < val) {
            cur = cur.next;
        }
        ListNode new = new ListNode(val);
        new.next = cur.next;
        cur.next = new;

        return dummy.next;
    }
}