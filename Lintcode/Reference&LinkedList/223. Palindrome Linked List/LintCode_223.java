public class LintCode_223 {
    /**
     * @param head: A ListNode.
     * @return: A boolean.
     * first attempt: 1) reverse the linked list 2) check whether original is equal to the reversed one
     */
    public boolean isPalindrome(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalf = reverse(middle.next);
        middle.next = secondHalf;

        while (head != null && secondHalf != null && head.val == secondHalf.val) {
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return secondHalf == null;


    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}