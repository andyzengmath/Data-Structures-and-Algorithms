public class LintCode_513 {
    /** Leet279
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // DP cannot pass lintcode
        int[] dp = new int[n + 1];
        for (int i = 0; i <= 0; i++) {
            dp[i] = 0;
        }
        int max_square_index = (int)Math.sqrt(n) + 1;
        int[] square_sums = new int[max_square_index];
        for (int i = 0; i < max_square_index; i++) {
            square_sums[i] = i * i;
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < max_square_index; j++) {
                if (i < square_sums[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_sums[j]] + 1);
            }
        }
        return dp[n];
    }
}