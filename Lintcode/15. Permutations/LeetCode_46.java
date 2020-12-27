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

    // Jiuzhang use Next Permutation 
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        boolean next = true;
        while (next) {
            List<Integer> current = new ArrayList<>();
            for (int num: nums) {
                current.add(num);
            }
            result.add(current);
            next = nextPermutation(nums);
        }
        return result;
    }

    public void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }

    public boolean nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i <= 0) return false;
        int j = len - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swapItem(nums, j, i - 1);
        swapList(nums, i, len - 1);

        return true;
    }
}