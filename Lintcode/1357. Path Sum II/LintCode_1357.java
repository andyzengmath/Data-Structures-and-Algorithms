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

public class LintCode_1357 {
    /** Leet 113
     * @param root: a binary tree
     * @param sum: the sum
     * @return: the scheme
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque();
        dfs(root, sum, path, result);
        return result;
    }

    public void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum, path, result);
        dfs(root.right, sum, path, result);
        path.pollLast();
    }
}