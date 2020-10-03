public class LintCode_151 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices.length < 2) return 0;
        int len = prices.length;
        int[][][] dp = new int[len][2][3];
        for (int i = 0; i < 2; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = - prices[0];
        }
        
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i-1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = 0;
        }
        
        return Math.max(dp[len - 1][0][2], dp[len - 1][0][1]);
    }
}