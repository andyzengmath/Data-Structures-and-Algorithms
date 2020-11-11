public class LintCode_392 {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) return nums[0];
        
        long[] dp = new long[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    // reduce space to O(1)
    public long houseRobber(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) return nums[0];
        
        
        long prev = nums[0];
        long curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            long temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
        }
        return curr;
    }
}