public class AnotherSol {
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr.next!= null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                curr.next = curr.next.next;
            }
        }
        
        return dummy.next;
    }
}