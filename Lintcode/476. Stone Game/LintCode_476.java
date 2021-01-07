public class LintCode_476 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        int size = A.length;
        if (A == null || size == 0) {
            return 0;
        }
        int[][] dp = new int[size][size];
        int[] sum_a = new int[size + 1];
        for (int i = 0; i < size; i++) {
            sum_a[i + 1] = sum_a[i] + A[i];
        }
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i + len - 1 < size; i++) {
                int l = i, r = i + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int j = l; j < r; j++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][j] + dp[j + 1][r] + sum_a[r + 1] - sum_a[l]);
                }
            }
        }
        return dp[0][size - 1];
    }
}