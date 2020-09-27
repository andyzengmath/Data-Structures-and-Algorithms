public class LintCode_17 {
    /** LeetCode-78 pass LintCode need
     * @param nums: A set of numbers
     * @return: A list of lists
     */ 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // dfs搜索
        Deque<Integer> subset = new ArrayDeque<>(nums.length);
        dfs(nums, 0, subset, res);
        return res;
    }
    private void dfs(int[] nums, int k, Deque<Integer> subset, List<List<Integer>> res) {
        // 当前组合存入res
        res.add(new ArrayList<>(subset));
        // 为subset新增一位元素
        for (int i = k; i < nums.length; ++i) {
            subset.addLast(nums[i]);
            // 下一层搜索
            dfs(nums, i + 1, subset, res);
            // 回溯
            subset.removeLast();
        }
    }
}