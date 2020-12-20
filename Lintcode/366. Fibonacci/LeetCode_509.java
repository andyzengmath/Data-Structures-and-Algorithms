class Solution {
    // note in leetcode F[0] = 0, F[1] = 1
    public int fib(int N) {
        if (N <= 1) return N;
        int[] dp = new int[3];
        dp[0 % 3] = 0;
        dp[1 % 3]= 1;
        for (int i = 2; i <= N; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[N % 3];
    }
}