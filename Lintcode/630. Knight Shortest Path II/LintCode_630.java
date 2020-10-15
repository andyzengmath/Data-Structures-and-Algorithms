public class LintCode_630 {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        int n  = grid.length, m = grid[0].length;
        if (n == 0 || m == 0) {
            return -1;
        }
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (!grid[i][j]) {
                        if (i >= 1 && j >= 2 && dp[i - 1][j - 2] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 2] + 1);
                        }
                        if (i + 1 < n && j >= 2 && dp[i + 1][j - 2] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 2] + 1);
                        }
                        if (i >= 2 && j >= 1 && dp[i - 2][j - 1] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 2][j - 1] + 1);
                        }
                        if (i + 2 < n && j >= 1 && dp[i + 2][j - 1] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i + 2][j - 1] + 1);
                        }
                    }
                }         
            }
        }
        if (dp[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n - 1][m - 1];

    }
}