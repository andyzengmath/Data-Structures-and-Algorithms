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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        this.stack = new Stack<TreeNode>();
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return this.stack.size() > 0;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode curr = this.stack.pop();
        if (curr.right != null) {
            this._leftmostInorder(curr.right);
        }
        return curr;
    }
}