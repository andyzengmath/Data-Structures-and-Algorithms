public class LintCode_372 {
    /*
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null) {
            return;
        } else if (node.next == null) {
            node = null;
        } else if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }
}