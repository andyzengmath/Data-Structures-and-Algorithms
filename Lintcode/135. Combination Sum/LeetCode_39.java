class LeetCode_39{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    private static void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates,
        int target, int start) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    continue;
                }
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
    }
}