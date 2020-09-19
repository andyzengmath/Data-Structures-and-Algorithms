public class LintCode_153 {
    //LeetCode_40
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i + 1);
                cur.remove(cur.size() - 1);
            }
    }
}