public class LintCode_451 {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        ListNode curr = head;
        ListNode temp = null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (curr != null) {
            if (curr.next == null) {
                break;
            } else {
                temp = curr.next.next;
                pre.next = curr.next;
                pre.next.next = curr;
                curr.next = temp;
    
                pre = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }    
}