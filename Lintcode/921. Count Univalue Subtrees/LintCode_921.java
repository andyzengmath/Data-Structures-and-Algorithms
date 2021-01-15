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

public class LintCode_921 {
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    int count = 0;
    private boolean is_valid_part(TreeNode node, int val) {
        if (node == null) return true;
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val)) return false;
        count++;
        return node.val == val;
    }
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        is_valid_part(root, 0);
        return count;
    }
}