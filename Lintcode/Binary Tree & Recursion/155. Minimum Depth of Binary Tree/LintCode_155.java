public class LintCode_155 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } 
        return minDepth(root.left) + 1;
        
    }