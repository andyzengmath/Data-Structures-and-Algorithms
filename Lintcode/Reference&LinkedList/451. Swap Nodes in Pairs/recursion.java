public class recursion {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }
}