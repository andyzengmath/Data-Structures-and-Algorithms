public class LintCode_113 {
    /**
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;


        while (curr.next != null && curr.next.next != null) {
            if (curr.next.next.val == curr.next.val) {
                int val = curr.next.val;
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
                }

            }

        return dummy.next;
        
    }
}