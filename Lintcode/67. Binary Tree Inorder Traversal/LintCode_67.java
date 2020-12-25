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


    // Morris
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        TreeNode cur = null;
        while (root != null) {
            if (root.left != null) {
                cur = root.left;
                while (cur.right != null && cur.right != root) {
                    cur = cur.right;
                }
                if (cur.right == root) {
                    nums.add(root.val);
                    cur.right = null;
                    root = root.right;
                } else {
                    cur.right = root;
                    root = root.left;
                }
            } else {
                nums.add(root.val);
                root = root.right;
            }
        }
        return nums;
    }
}