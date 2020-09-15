/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class LintCode_104 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // need O(N logk) algorithm
        if (lists.size() == 0) {
            return null;
        }
        int k = lists.size();
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists.set(idx++, lists.get(i));
                } else {
                    lists.set(idx++, merge2Lists(lists.get(i), lists.get(i + 1)));
                }
            }
            k = idx;
        }
        return lists.get(0);

    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        //(iterative)
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null? l2: l1;
        return dummy.next;
    }

    public ListNode mergeRecursive(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return merge(lists, 0, list.size() - 1);
    }

    private ListNode merge(ListNode<ListNode> lists, int lo, int hi) {
        if (lo == hi) {
            return lists.get(lo);
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);

        return merge2Lists(l1, l2);
    }
}
