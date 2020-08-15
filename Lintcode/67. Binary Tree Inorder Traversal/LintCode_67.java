public class LintCode_67 {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            result.add(curr.val);

            if (curr.right == null) {
                curr = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == curr) {
                    curr = stack.pop();
                }
            } else {
                curr = curr.right;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
            
        }

        return result;
    }
}