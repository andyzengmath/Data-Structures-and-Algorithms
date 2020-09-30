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

public class LintCode_72 {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    private Map<Integer, Integer> indexMap;
    int post_idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_idx = postorder.length - 1;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <= post_idx; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, inorder.length - 1);
        
    }
    

    private TreeNode myBuildTree(int[]inorder, int[] postorder, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int in_root = indexMap.get(postorder[post_idx]);
        TreeNode root = new TreeNode(postorder[post_idx]);
        
        post_idx--;
        
        root.right = myBuildTree(inorder, postorder, in_root + 1, in_right);
        root.left = myBuildTree(inorder, postorder, in_left, in_root - 1);

        return root;
    }
}