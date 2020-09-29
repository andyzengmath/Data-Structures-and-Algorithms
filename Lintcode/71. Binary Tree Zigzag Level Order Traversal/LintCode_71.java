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

public class LintCode_71 {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.add(root);
        node_queue.add(null);
        
        LinkedList<Integer> level_list = new LinkedList<>();
        boolean leftRight = true;
        
        while (node_queue.size() > 0) {
            TreeNode curr = node_queue.pollFirst();
            if (curr != null) {
                if (leftRight) {
                    level_list.addLast(curr.val);
                } else {
                    level_list.addFirst(curr.val);
                }
                
                if (curr.left != null) {
                    node_queue.addLast(curr.left);
                }
                if (curr.right != null) {
                    node_queue.addLast(curr.right);
                }
            } else {
                results.add(level_list);
                level_list = new LinkedList<>();
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                leftRight = !leftRight;
            }
            
        }
        return results;
    }
}