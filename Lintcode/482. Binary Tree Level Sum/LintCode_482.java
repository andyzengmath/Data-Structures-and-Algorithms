public class LintCode_482 {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    private int sum = 0;

    public int levelSum(TreeNode root, int level) {
        // write your code here
        helper(root, 1, level);
        return sum;
    }

    private void helper(TreeNode root, int depth, int level) {
        if (root == null) {
            return;
        }
        if (depth == level) {
            sum += root.val;
            return;
        }
        helper(root.left, depth + 1, level);
        helper(root.right, depth + 1, level);
    }
}