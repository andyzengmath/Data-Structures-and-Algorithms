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

public class LintCode_170 {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null) return head;
        ListNode oldTail = head;

        int num = 1;
        while (oldTail.next != null) {
            num++;
            oldTail = oldTail.next;
        }
        System.out.print(num);

        oldTail.next = head;
        ListNode newTail = head;
        for (int i = 0; i < num - k % num - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}