class LeetCode_131 {
    // dp + dfs
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) return res;
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracing(s, 0, len, dp, stack, res);
        return res;
    }
    
    private void backtracing(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < len; i++) {
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracing(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
        
    }
}