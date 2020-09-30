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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class LintCode_106 {
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */

    ListNode globalRoot;
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        globalRoot = head;
        int len = getLen(head); 
        return buildTree(0, len - 1);
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(0);
        root.left = buildTree(left, mid - 1);
        root.val = globalRoot.val;
        globalRoot = globalRoot.next;
        root.right = buildTree(mid + 1, right);
        return root;

    }

    public int getLen(ListNode head) {
        int num = 0;
        while (head != null) {
            ++num;
            head = head.next;
        }
        return num;
    }
}