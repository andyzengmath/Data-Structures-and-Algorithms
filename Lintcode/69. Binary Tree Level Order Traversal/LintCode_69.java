import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LintCode_69 {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     * Challenge 1: Using only 1 queue to implement it.
     * Challenge 2: Use BFS algorithm to do it.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        // BFS
        ArrayList result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
        
    }
}