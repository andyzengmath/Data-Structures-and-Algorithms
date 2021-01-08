class LeetCode_44 {
    // dp quite slow 10%/12%
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (
                        s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '?'
                    );
                }
            }
        }
        return dp[n][m];  
    }

    // 滚动数组
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[2][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= n; i++) {
            dp[i % 2][0] = false;
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] || dp[i % 2][j - 1];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] && (
                        s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '?'
                    );
                }
            }
        }
        return dp[n % 2][m];  
    }
}