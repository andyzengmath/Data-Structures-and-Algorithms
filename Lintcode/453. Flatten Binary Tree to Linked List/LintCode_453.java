public class LintCode_453 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     * Challenge: Do it in-place without any extra memory.

     */
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);

    }
}