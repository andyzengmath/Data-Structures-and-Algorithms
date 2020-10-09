public class LintCode_191 {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int maxf = nums[0], minf = nums[0], ans = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int max = maxf, min = minf;
            maxf = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            minf = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
            ans = Math.max(maxf, ans);
        }
        return ans;
    }
}