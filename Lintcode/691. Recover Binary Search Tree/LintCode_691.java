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

public class LintCode_691 {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        if (root == null) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null, oldroot = root;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root; 
            root = root.right;
        }
        if (x == null && y == null) {
            return oldroot;
        } else {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;

        return oldroot;
        }
    }
}