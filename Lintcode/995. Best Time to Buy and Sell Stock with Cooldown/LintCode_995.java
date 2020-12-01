public class LintCode_995 {
    /**
     * @param prices: a list of integers
     * @return: return a integer
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
    // O(1) space
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices.length < 2) return 0;
        int[][] dp = new int[2][3];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][2]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
            dp[i % 2][2] = dp[(i - 1) % 2][1] + prices[i];
        }
        return Math.max(dp[(prices.length - 1) % 2][0], dp[(prices.length - 1) % 2][2]);
    }
}