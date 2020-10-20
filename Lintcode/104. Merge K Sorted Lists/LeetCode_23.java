/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode_23 {
    // 10-19-2o review
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int k = lists.length;
        
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i]; // edge case
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx; //reset k
        }
        return lists[0];
    }
    
    public ListNode merge2Lists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy; // first node 
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        pre.next = (node1 == null) ? node2: node1;
        return dummy.next;
    }
}