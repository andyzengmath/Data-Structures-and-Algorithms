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

public class LintCode_1181 {
    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    private int maxLen = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code 
        depth(root);
        return maxLen;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        maxLen = Math.max(maxLen, L + R);
        return Math.max(L, R) + 1;
    }
}