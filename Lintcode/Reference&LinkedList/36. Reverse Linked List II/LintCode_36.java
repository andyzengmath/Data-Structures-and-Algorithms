public class LintCode_36 {
    /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        ListNode curr = dummy;
        
        for (int i = 0; i < m; i++) {
            if (curr == null) {
                return null;
            }
            pre = curr;
            curr = curr.next;
        }
        

        ListNode pre2 = pre;
        ListNode temp = pre;
        pre = pre.next;
        ListNode pre3 = pre;
        curr = curr.next;
        for (int i = m; i < m + n - 1; i++) {
            if (curr == null) {
                return null;
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        pre2.next = curr;
        pre.next = pre3;

        return dummy.next;
    }
}