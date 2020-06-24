

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
 * 
 */

public class LintCode_174 {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     * Challenge: Can you do it without getting the length of the linked list?
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode curr = head;
        ListNode nAfter = head;
        ListNode pre = head;
        
        if (head.next == null) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            nAfter = nAfter.next;
        }

        if (nAfter == null) {
            return head.next;
        } else {
            while (nAfter != null) {
                pre = curr;
                curr = curr.next;
                nAfter = nAfter.next;
            }
    
            pre.next = curr.next;
            return head;
        }
    }
}