public class LintCode_41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * Can you do it in time complexity O(n)?
     * 
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        // prefix sum
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
        }

        return max;
    }
}