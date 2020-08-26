public class dfs {
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cloneRoot = new TreeNode(root.val) 
        cloneRoot.left = cloneTree(root.left);
        CloneRoot.right = cloneTree(root.right);
        return cloneRoot;
    }
}