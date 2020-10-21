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

public class LintCode_1704 {
    /** Leet 938
     * @param root: the root node
     * @param L: an integer
     * @param R: an integer
     * @return: the sum
     */
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        // dfs
        ans = 0;
        dfs(root, L, R);
        return ans;

    }
    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                ans += node.val;
            }
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (R > node.val) {
                dfs(node.right, L, R);
            }
        }
    }
}