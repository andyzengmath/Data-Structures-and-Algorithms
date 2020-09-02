public class LintCode_596 {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     * LintCode will print the subtree which root is your return node.
     * It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.
     */
    private int minSum;
    private TreeNode minRoot;
    public TreeNode findSubtree(TreeNode root) {
        // divide & conquer + traverse
        minSum = Integer.MAX_VALUE;
        minRoot = null;
        getSum(root);
        return minRoot;
    }

    private void getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = getSum(root.left) + getSum(root.right) + root.val;
        if (sum < minSum) {
            minSum = sum;
            minRoot = root;
        }
    }
}