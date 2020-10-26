class LeetCode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        List<Integer> path = new ArrayList<>(); // ArrayList faster than ArrayDeque
        Arrays.sort(nums);
        dfs(nums, 0, res, path);
        return res;
    }
    private void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
        
    }
}