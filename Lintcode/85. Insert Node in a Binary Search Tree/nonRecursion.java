public class nonRecursion {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null) {
            pre = cur;

            if (cur.val > node.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (pre.val > node.val) {
            prev.left = node;
        } else {
            prev.right = node;
        }

        return root;
    }
}