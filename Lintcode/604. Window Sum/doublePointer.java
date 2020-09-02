public class doublePointer {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k || k < 0) {
            return new int[0];
        }
        int[] results = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        results[0] = sum;

        int left = 0, right = k;
        int i = 1;
        while (right < nums.length) {
            sum = sum + nums[right] - nums[left];
            results[i++] = sum;
            left++;
            right++;
        }
        return left;
    }
}