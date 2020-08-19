public class LintCode_167 {
    /**
     * Frequently asked question ++
     * Airbnb,Amazon,Microsoft,Bloomberg,Adobe
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int add = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;


        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val;
                curr.next = new ListNode((sum + add) % 10);
                add = (sum + add) / 10;
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                curr.next = new ListNode((l1.val + add) % 10);
                add = (l1.val + add) / 10;
                curr = curr.next;
                l1 = l1.next;
            } else if (l2 != null) {
                curr.next = new ListNode((l2.val + add) % 10);
                add = (l2.val + add) / 10;
                curr = curr.next;
                l2 = l2.next;
            }
            
        }
        if (add != 0) {
            curr.next = new ListNode(add);
        }
        return dummy.next;
    }
}