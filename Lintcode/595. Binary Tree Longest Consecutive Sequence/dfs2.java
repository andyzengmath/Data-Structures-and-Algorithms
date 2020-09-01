public class dfs2 {
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        dfs(root, 0, root.val + 1);
        return max;
    }

    private void dfs(TreeNode root, int length, int target) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            length++;
        } else {
            length = 1;
        }
        max = Math.max(max, length);
        dfs(root.left, length, root.val + 1);
        dfs(root.right, length, root, val + 1);
    }
}