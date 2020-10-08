/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LintCode_99 {
    /** Leet 143
     * Can you do this in-place without altering the nodes' values?
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int len = 0;
        ListNode h = head;
        while (h != null) {
            len++;
            h = h.next;
        }

        reorder(head, len);
    }

    private ListNode reorder(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        ListNode tail = reorder(head.next, len - 2);
        ListNode subhead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subhead;
        return outTail;
    }
}