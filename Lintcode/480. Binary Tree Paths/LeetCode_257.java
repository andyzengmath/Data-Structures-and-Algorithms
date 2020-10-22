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
LeetCode_257 Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        dfs(root, "", paths);
        return paths;
    }
    
    public void dfs(TreeNode root, String s, List<String> paths) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(s);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
                return;
            } else {
                sb.append("->");
                dfs(root.left, sb.toString(), paths);
                dfs(root.right, sb.toString(), paths);
            }
        }
        
    }
}