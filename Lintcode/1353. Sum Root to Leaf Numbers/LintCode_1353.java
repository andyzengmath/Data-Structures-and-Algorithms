/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class LintCode_1353 {
    /**
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    int result = 0;

    public int sumNumbers(TreeNode root) {
        // write your code here
        dfs(root, 0);
        return result;
    }
    
    private void dfs (TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) result += sum;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}