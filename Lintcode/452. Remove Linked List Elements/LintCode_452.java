public class LintCode_452 {
    /**
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode currHead = head;
        
        while (currHead != null && currHead.val == val) {
            currHead = currHead.next;
            pre.next = currHead;
        }
        
        while (pre.next != null) {
            if (pre.next.val == val){
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return currHead;
    }
}