public class inPlace {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        while (l1.next != null && l2.next != null) {
            carry = advance(l1, l2, carry);
            l1 = l1.next;
            l2 = l2.next;
        }

        carry = advance(l1, l2, carry);

        if (l1.next == null) {
            l1.next = l2.next;
        }

        while (l1.next != null) {
            int prevCarry = carry;
            carry = (l1.next.val + prevCarry) / 10;
            l1.next.val = (l1.next.val + prevCarry) % 10;
            l1 = l1.next;
        }

        if (carry == 1) {
            l1.next = new ListNode(1);
        }

        return head;
    }

    private int advance(ListNode l1, ListNode l2, int carry) {
        int prevCarry = carry;
        carry = (l1.val + l2.val + prevCarry) / 10;
        l1.val = (l1.val + l2.val + prevCarry) % 10;

        return carry;
    }
}