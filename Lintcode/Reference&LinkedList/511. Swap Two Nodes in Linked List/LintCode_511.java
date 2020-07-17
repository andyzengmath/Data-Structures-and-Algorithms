public class LintCode_511 {
    /**
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode pre1 = null;
        ListNode pre2 = null;

        while (head != null) {
            if (head.val == v1 || head.val == v2) {
                pre1 = pre;
                break; 
            }
            head = head.next;
            pre = pre.next;
        }

        while (head != null) {
            if (head.val == v1 || head.val == v2) {
                pre2 = pre; 
            }
            head = head.next;
            pre = pre.next;
        }

        if (pre1 == null || pre2 == null || pre1 == pre2) {
            return dummy.next;
        } else if (pre1.next == pre2) {
            ListNode temp = pre1.next.next;
            pre2.next = pre2.next.next;
            pre1.next = temp;
            temp.next = pre2;
        } else {
            ListNode temp = pre1.next, temp2 =pre2.next.next;
            pre1.next = pre2.next;
            pre1.next.next = temp.next;
            pre2.next = temp;
            pre2.next.next = temp2;
        }

        return dummy.next;

    }
}