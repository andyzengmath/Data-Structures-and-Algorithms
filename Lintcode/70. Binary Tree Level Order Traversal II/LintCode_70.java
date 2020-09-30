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

public class LintCode_70 {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // write your code here
            List<List<Integer>> result = new LinkedList<>();
            
            if (root == null) return result;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<Integer>();
                int size = queue.size();
                
                for (int i = 0; i < size; i++) { //note: don't use queue.size() in the loop!
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(0, level);
            }
            
            return result;
        }
    }
}