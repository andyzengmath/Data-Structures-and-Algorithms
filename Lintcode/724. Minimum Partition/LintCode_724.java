public class LintCode_724 {
    /**
     * @param nums: the given array
     * @return: the minimum difference between their sums 
     */
    public int findMin(int[] nums) {
        // write your code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            for (int j = sum / 2; j >= num; j--) {
                dp[j] |= dp [j - num];
            }
        }

        int i = 0; 
        for (i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                break;
            }
        }
        return sum - 2 * i;
    }
}