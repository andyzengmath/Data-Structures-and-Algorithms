public class LintCode_149 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) return 0;
        int minVal = prices[0];
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minVal);
        }
        return maxPro;
    }
}