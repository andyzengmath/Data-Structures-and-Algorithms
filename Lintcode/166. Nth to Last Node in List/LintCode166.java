public class LintCode166 {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null || ((head.next == null) && n == 0) ) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;

    }
}