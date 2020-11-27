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

public class LintCode_1311 {
    /**
     * @param root: root of the tree
     * @param p: the node p
     * @param q: the node q
     * @return: find the LCA of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // write your code here
        TreeNode ancester = root;
        while (true) {
            if (p.val < ancester.val && q.val < ancester.val) {
                ancester = ancester.left; 
            } else if (p.val > ancester.val && q.val > ancester.val) {
                ancester = ancester.right;
            } else {
                break;
            }
        }
        
        return ancester;
        
    }
}