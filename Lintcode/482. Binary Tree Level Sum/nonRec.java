public class nonRec {
    public int levelSum(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1, sum = 0;
        queue.offer(root);
        while (!queue.isEmpty() && count < level) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        if (count == level) {
            while (!queue.isEmpty()) {
                sum += queue.poll().val;
            }
        }
        return sum;
    }
}