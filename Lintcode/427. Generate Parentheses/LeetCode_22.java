class LeetCode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, 0, n, res);
        return res;
    }
    
    private void dfs(StringBuilder sb, int left, int right, int n, List<String> res) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return; // note need return
        }
        if (left < n) {
            sb.append('(');
            dfs(sb, left + 1, right, n, res);
            sb.deleteCharAt(sb.length() - 1); // need delete
        }
        if (right < left) {
            sb.append(')');
            dfs(sb, left, right + 1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}