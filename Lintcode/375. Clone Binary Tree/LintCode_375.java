public class LintCode_375 {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        traverse(root, head);
        return head;
    }

    private void traverse(TreeNode root, TreeNode head) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        if (cur.left != null) {
            TreeNode left = new TreeNode(cur.left.val);
            head.left = left;
        }
        if (cur.right != null) {
            TreeNode right = new TreeNode(cur.right.val);
            head.right = right;
        }
        traverse(root.left, head.left);
        traverse(root.right, head.right);
    }
}