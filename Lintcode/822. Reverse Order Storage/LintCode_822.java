/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LintCode_822 {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    List<Integer> res = new ArrayList<>();
    
    private void store(ListNode p) {
        if (p == null) {
            return;
        }
        store(p.next);
        res.add(p.val);
    }
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        store(head);
        return res;

        

    }
}