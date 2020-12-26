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

public class LintCode_701 {
    /**
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (root.val < minimum) {
            return trimBST(root.right, minimum, maximum);
        } else if (root.val > maximum) {
            return trimBST(root.left, minimum, maximum);
        } else {
            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);
        }

        return root;
    }
}