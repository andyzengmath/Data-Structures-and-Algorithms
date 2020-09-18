public class LintCode_135 {
    /** Leet code 39 note that LeetCode has no duplicates!
     * 
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        int[] candidatesNew = removeDuplicates(candidates);

        getResult(result, new ArrayList<>(), candidatesNew, target, 0);
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
    
    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] candidatesNew = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            candidatesNew[i] = candidates[i];
        }
        return candidatesNew;
    }
}