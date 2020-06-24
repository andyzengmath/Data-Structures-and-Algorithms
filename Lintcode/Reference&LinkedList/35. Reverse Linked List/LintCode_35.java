import java.util.ListIterator;

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 }
 
public class LintCode_35 {
    //Challenge: Reverse it in-place and in one-pass
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = new ListNode();

        while (cur.hasNext()) {
            next = head.next();
            cur.next = pre;
            
            pre = cur;
            cur = next;
        }
        
    }

}