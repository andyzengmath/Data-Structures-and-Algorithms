public class LintCode_628 {
    /** see also 596
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    private TreeNode result = null;
    private int maximum_weight = Integer.MIN_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        helper(root);
        return result;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_weight = helper(root.left);
        int right_weight = helper(root.right);

        if (result == null || left_weight + right_weight + root.val > maximum_weight) {
            maximum_weight = left_weight + right_weight + root.val;
            result = root;
        }
        return left_weight + right_weight + root.val;
    }
}
