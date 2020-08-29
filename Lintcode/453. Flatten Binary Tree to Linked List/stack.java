import java.util.Stack;

import javax.swing.tree.TreeNode;

public class stack {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                TreeNode temp = stack.peek();
                cur.right = temp;
            }
            cur.left = null;
        }
    }
}