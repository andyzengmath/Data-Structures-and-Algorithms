public class LintCode_18 {
    /**  
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        ArrayDeque<Integer> subset = new ArrayDeque<>();
        dfs(nums, 0, subset, result);
        return result;

    }

    public void dfs(int[] nums, int k, ArrayDeque subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = k; i < nums.length; i++) {
            if (i != k && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.addLast(nums[i]);
            dfs(nums, i + 1, subset, result);
            subset.removeLast();
        }
    }
}