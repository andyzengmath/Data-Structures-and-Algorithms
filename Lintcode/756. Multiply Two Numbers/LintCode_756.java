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

public class LintCode_756 {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the product list of l1 and l2
     */
    public long multiplyLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode p = new ListNode(0);
        p = l1;
        long num1 = 0;
        while (p != null) {
            num1 *= 10;
            num1 += p.val;
            p = p.next;
        }
        p = l2;
        long num2 = 0;
        while (p != null) {
            num2 *= 10;
            num2 += p.val;
            p = p.next;
        }
        return num1 * num2;
    }
}