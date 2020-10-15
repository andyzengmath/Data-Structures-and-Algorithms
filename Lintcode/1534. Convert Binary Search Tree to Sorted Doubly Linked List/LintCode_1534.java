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
 */

public class LintCode_1534 {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);

        TreeNode head = list.get(0);
        TreeNode tail = list.get(list.size() - 1);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void helper(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node);
        if (list.size() >= 2) {
            TreeNode a = list.get(list.size() - 2);
            TreeNode b = list.get(list.size() - 1);
            a.right = b;
            b.left = a;
        }
        helper(node.right, list);
    }
}