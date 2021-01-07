class LeetCode_312 {
    // dp very slow!
    public int maxCoins(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length + 2;
        int[] arr = new int[n];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[n - 1] = 1;
        int[][] dp = new int[n][n];

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[j] * arr[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}