public class nonRecursion {
    // time complexity O(n)
    public boolean isValidBST(TreeNode root) {
        stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode lastNode = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (lastNode != null && lastNode.val >= node.val) {
                return false;
            }
            lastNode = node;

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }

            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return true;
    }
}