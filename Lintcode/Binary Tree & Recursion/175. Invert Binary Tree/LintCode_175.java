public class LintCode_175 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if 

        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            invertBinaryTree(root.left);
        }
        
        if (root.right != null) {
            invertBinaryTree(root.right);
        }
    }
}