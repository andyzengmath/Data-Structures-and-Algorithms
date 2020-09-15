public class LintCode_427 {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> result = new ArrayList<String>();
        dfs(0, 0, "", n, result);
        return result;
    }

    private void dfs(int leftCount, int rightCount, String curr, int n, List<String> result) {
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount < rightCount) {
            return;
        }

        if (leftCount == n && rightCount == n){
            result.add(curr);
            return;
        }

        dfs(leftCount + 1, rightCount, curr + "(", n, result);
        dfs(leftCount, rightCount + 1, curr + ")", n, result);

    }
}