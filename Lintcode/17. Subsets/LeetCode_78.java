class LeetCode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(j+1, nums, res, path);
            path.remove(path.size() - 1);
        }
    }
}

// 10-25-20 review 100% speed

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, res, path);
        return res;
    }
    
    private void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> path) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, pos + 1, res, path);
        path.add(nums[pos]);
        dfs(nums, pos + 1 ,res, path);
        path.remove(path.size() - 1);
    }
}