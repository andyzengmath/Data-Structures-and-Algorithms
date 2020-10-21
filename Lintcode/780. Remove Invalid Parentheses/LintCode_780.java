public class LintCode_780 {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    char[][] patterns = {{'(', ')'}, {')', '('}};
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        dfs(new StringBuilder(s), 0, 0, patterns[0], res);
        return res;
    }

    private void dfs (StringBuilder s, int start, int lastRemove, char[] pattern, List<String> res) {
        int count = 0, n = s.length();
        for (int i = start; i < n; i++) {
            if (s.charAt(i) == pattern[0]) {
                count++;
            }
            if (s.charAt(i) == pattern[1]) {
                count--;
            }
            if (count >= 0) continue;
            for (int j = i; j >= lastRemove; j--) {
                char d = s.charAt(j);
                if (d != pattern[1] || j > lastRemove && d == s.charAt(j - 1)) {
                    continue;
                }
                s.deleteCharAt(j);
                dfs(s, i, j, pattern, res);
                s.insert(j, d);
            }
            return;
        }
        s.reverse();
        if (pattern[0] == patterns[0][0]) {
            dfs(s, 0, 0, patterns[1], res);
        } else {
            res.add(s.toString());
        }
        s.reverse();
        
    }
}