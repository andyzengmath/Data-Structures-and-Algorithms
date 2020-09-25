class LeetCode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (j = i; j < nums.length; j++) {
            path.add(j);
            dfs(j+1, nums, res, path);
            path.remove(path.size() - 1);
        }
    }
}