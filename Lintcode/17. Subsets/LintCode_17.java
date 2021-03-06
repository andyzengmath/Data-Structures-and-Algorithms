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


    // BFS 1
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> queue = new ArrayList<>();
        int index = 0;

        Arrays.sort(nums);
        queue.add(new ArrayList<Integer>());
        while (index < queue.size()) {
            List<Integer> subset = queue.get(index++);
            for (int i = 0; i < nums.length; i++) {
                if (subset.size() != 0 && subset.get(subset.size() - 1) >= nums[i]) {
                    continue;
                }
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(nums[i]);
                queue.add(newSubset);
            }
        }
        return queue;
    }

    // BFS 2 slower
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> queue = new ArrayList<>();
        queue.add(new LinkedList<Integer>());
        Arrays.sort(nums);

        for (int num: nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(queue.get(i));
                subset.add(num);
                queue.add(subset);
            }
        }
        return queue;
    }
}