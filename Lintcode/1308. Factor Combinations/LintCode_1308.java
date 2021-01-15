public class LintCode_1308 {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                dfs(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
