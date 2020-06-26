public class LintCode_112 {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        ListNode curr = dummy;
        
        
        Set<Integer> elements = new HashSet <Integer>();
        
        
        while (curr.next!= null) {
            if (elements.contains(curr.next.val)){
                curr.next = curr.next.next;
            } else {
                elements.add(curr.next.val);
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}