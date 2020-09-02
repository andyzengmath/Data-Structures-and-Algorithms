public class LintCode_597 {
    
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     * 为了避免出现精度问题，我们可以把 root.sum / root.num > ans.sum / ans.num 的判断移项成乘法：root.sum   ans.num > ans.sum root.num
     */
    private class Result {
        int sum, num;
        public Result(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }
    }
    private TreeNode maxAvg = null;
    private Result maxAvgData = null;

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        dfs(root);
        return maxAvg;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        Result rootResult = new Result(left.sum + right.sum + root.val, left.num + right.num + 1);
        if (maxAvg == null || maxAvgData.num * rootResult.sum > maxAvgData.sum * rootResult.num) {
            maxAvg = root;
            maxAvgData = rootResult;
        }
        return rootResult;
    }
}