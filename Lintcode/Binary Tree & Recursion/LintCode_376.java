import java.util.Deque;

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

public class LintCode_376 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, target, path, result);
        
        return result;
    }

    public void dfs(TreeNode root, int target, Deque<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);

        if (root.left == null && root.right == null) {
            if (target == root.val) {
                result.add(new ArrayList<>(path));
            }
            path.removeLast();
            return;
        }

        dfs(root.left, target - root.val, path, result);
        dfs(root.right, target - root.val, path, result);
        path.removeLast();
    }
}