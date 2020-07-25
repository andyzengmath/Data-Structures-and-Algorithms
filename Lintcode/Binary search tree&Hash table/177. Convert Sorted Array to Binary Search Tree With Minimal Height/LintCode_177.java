public class LintCode_177 {
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        int n = A.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(A[n/2]);
        int[] left = new int[n/2];
        int[] right = new int[n - n/2 - 1];
        for (int i = 0; i < n/2; i++) {
            left[i] = A[i];
        }
        for (int j = n/2 + 1; j < n; j++) {
            right[j - n/2 - 1] = A[j];
        }

        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);

        return root;
    }
}