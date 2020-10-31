/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LeetCode_101 {
    // 10-31-20 iterative version
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror (TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            root1 = queue.poll();
            root2 = queue.poll();
            if (root1 == null && root2 == null) continue;
            if ((root1 == null || root2 == null) || root1.val != root2.val) return false;
            queue.offer(root1.left);
            queue.offer(root2.right);
            queue.offer(root1.right);
            queue.offer(root2.left);
        }
        return true;
    }
}