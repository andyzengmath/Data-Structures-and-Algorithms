public class LintCode_93 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;


    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1  || left == -1 || right == -1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}