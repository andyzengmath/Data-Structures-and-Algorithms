import java.util.Stack;

import javax.swing.tree.TreeNode;

public class LintCode_68 {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
                
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } 
            } else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
}