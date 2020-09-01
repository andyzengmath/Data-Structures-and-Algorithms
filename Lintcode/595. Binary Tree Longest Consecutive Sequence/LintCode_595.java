public class LintCode_595 {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        //dfs 
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int lenWithoutRoot) {
        if (root == null) return 0;
        int length = (parent != null && parent.val + 1 == root.val)
            ? lenWithoutRoot + 1 : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }
}