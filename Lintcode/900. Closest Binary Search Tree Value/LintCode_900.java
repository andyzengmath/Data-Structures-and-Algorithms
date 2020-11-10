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

public class LintCode_900 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // use inorder traversal
        LinkedList<TreeNode> stack = new LinkedList<>();
        long pred = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pred <= target && target < root.val) {
                return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;
            }
            pred = root.val;
            root = root.right;
        }
        return (int)pred;
    }
}