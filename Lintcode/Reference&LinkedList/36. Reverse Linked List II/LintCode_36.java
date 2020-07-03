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
            pre = curr;
            curr = curr.next;
        }
        

        ListNode pre2 = pre;
        for (int i = m; i < m + n; i++) {
            
        }

        return dummy.next;
        



    }
}