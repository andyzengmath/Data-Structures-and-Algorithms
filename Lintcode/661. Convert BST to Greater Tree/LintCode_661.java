public class LintCode_661 {
    /**
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // in order
        travel(root, 0);
        return root;
    }

    private int travel(TreeNode root, int now_sum) {
        if (root == null) {
            return now_sum;
        }

        now_sum = travel(root.right, now_sum); 
        now_sum += root.val;
        root.val = now_sum;
        
        now_sum = travel(root.left, now_sum);

        return now_sum;
    }
}
