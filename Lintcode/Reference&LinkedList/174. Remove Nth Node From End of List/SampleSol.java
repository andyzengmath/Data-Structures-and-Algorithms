public class SampleSol {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = head;

        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return temp.next;
    }
}