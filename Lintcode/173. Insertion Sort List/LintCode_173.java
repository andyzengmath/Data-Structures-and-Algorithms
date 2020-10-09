public class LintCode_173 {
    /** Leet 147 need improve speed
     * 
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode curr = dummy;
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            ListNode temp = head.next;
            head.next = curr.next;
            curr.next = head;
            head = temp;
        }

        return dummy.next;
    }
}