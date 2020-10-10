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

public class LintCode_649 {
    /**
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) return root;
        TreeNode result = root;
        while (result.left != null) result = result.left;

        upsideDown(root);
        return result;
    }

    private void upsideDown(TreeNode node) {
        if (node.left == null) return;
        upsideDown(node.left);

        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;
    }
}