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

public class LintCode_1359 {
    /**
     * @param nums: the sorted array
     * @return: the root of the tree
     */
    public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
        // Write your code here.
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
    }
}