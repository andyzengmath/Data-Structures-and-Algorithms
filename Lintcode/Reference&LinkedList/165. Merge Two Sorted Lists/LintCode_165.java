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

public class LintCode_165 {
    /** LeetCode-21
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = null; 

        if (l1.val < l2.val) {
            cur = l1;
            cur1 = l1.next;
            
        } else {         
            cur = l2;
            cur2 = l2.next;
        }

        ListNode head = cur;

        while (cur1 != null && cur2 != null) {
            
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
                
            } else if (cur2.val <= cur1.val) {
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
                
            }
        }
        
        if (cur1 != null) {
            cur.next = cur1;
        }
        
        if (cur2 != null) {
            cur.next = cur2;
        } 
        return head;
    }
}