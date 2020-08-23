import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LintCode_242 {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     * BFS time complexity O(n)
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<ListNode>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        
        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;

                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                
            }
            result.add(dummy.next);

        }
        return result;

    }
    
}
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */