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

public class LintCode_1317 {
    /**
     * @param root: root of complete binary tree
     * @return: the number of nodes
     */
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    
    public int countNodes(TreeNode root) {
        // write your code here
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}