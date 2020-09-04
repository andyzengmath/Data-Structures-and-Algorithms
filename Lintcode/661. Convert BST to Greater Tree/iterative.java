import java.util.Stack;

import javax.swing.tree.TreeNode;

import jdk.internal.jshell.tool.resources.l10n;

public class iterative {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop()o;
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
