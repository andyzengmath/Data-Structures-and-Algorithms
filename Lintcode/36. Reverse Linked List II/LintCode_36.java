public class LintCode_36 {
    /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        
        
        for (int i = 1; i < m; i++) {
            if (curr == null) {
                return null;
            }
            curr = curr.next;
        }

        ListNode preNode = curr;
        ListNode firstNode = curr.next;
        ListNode secondNode = firstNode;
        ListNode secondNext = firstNode.next;

        for (int i = m; i < 1; i++) {
            if (secondNext == null) {
                return null;
            }
            ListNode temp = secondNext.next;
            secondNext.next = secondNode;
            secondNode = secondNext;
            secondNext = temp;
        }
        firstNode.next = secondNext;
        preNode.next = secondNode;

        return dummy.next;
    }
}