public class LintCode_98 {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     * Sort a linked list in O(n log n) time using constant space complexity.
     * Solve it by merge sort & quick sort separately.
     */

    public ListNode sortList(ListNode head) {
        // write your code here
        // quick sort
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode start, ListNode end) {
        if (start >= end) {
            return;
        }
        ListNode pivot = partition(start, end);
        quickSort(start, pivot);
        quickSort(pivot.next, end);
    }

    private ListNode partition(ListNode start, ListNode end) {
        int key = start.val;
        ListNode p1 = start, p2 = start.next;
        while (p2 != end) {
            if (p2.val < key) {
                p1 = p1.next;
                swap(p1, p2);
            }
            p2 = p2.next;
        }

        swap(p1, start);
        return p1;
    }

    private void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}