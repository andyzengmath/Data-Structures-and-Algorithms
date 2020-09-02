public class presum {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k || k < 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] j= sum[i - 1] + nums[i];
        }
        int[] result = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            result[i - k + 1] = sum[i] - sum[i - k + 1] + nums[i - k + 1];
        }
        return result;
    }
}