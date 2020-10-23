public class LintCode_95 {
    /** fast iterative slow
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return divideAndConquer(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divideAndConquer(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return divideAndConquer(root.left, min, Math.min(max, root.val)) &&
                divideAndConquer(root.right, Math.max(min, root.val), max);
    }
}