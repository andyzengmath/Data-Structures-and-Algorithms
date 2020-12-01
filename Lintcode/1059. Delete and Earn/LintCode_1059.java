public class LintCode_1059 {
    /** Akuna
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int deleteAndEarn(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 0) return nums[0];
        
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(nums[i], max);
        }
        int[] freq = new int[max + 1];
        for (int num: nums) {
            freq[num]++;
        }
        
        int[] dp = new int[max + 1];
        dp[1] = freq[1];
        dp[2] = Math.max(dp[1], freq[2] * 2);
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * freq[i]);
        }
        return dp[max];
    }
}