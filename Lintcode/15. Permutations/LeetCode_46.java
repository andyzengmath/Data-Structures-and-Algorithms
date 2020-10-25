class LeetCode_46 {
    // 10-20-24 review
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Deque<Integer> path = new ArrayDeque<>(); // ArrayDeque is faster than Linkedlist
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, path, res, visited);
        return res;
    }
    private void dfs(int[] nums, int pos, Deque<Integer> path, List<List<Integer>> res, boolean[] visited) {
        if (pos == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, pos + 1, path, res, visited);
            visited[i] = false;
            path.removeLast();
        }
        
    }
}