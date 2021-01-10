public class LintCode_76 {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    // dp

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        
    }

    // binary search
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] lis = new int[nums.length + 1];
        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            lis[i] = Integer.MAX_VALUE;
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = firstGTE(lis, nums[i]);
            lis[index] = nums[i];
            longest = Math.max(longest, index);
        }
        return longest;
    }

    private int firstGTE(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        }
        return end;
    }

}