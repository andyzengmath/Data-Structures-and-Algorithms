public class LintCode_44 {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int minSum = Integer.MAX_VALUE, sum = 0, maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            minSum = Math.min(minSum, sum - maxSum);
            maxSum = Math.max(sum, maxSum); 
        }

        return minSum;
    }
}