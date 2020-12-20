class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[0] * (i + 1) for i in range(n)]
        dp[0][0] = triangle[0][0]
        for i in range(1, n):
            dp[i][0] = dp[i - 1][0] + triangle[i][0]
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]
        
        for i in range(2, n):
            for j in range(1, i):
                dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
        return min(dp[n - 1])
        
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[0] * n, [0] * n]
        dp[0][0] = triangle[0][0]
        for i in range(1, n):
            dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle[i][0]
            dp[i % 2][i] = dp[(i - 1) % 2][i - 1] + triangle[i][i]
            for j in range(1, i):
                dp[i % 2][j] = min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle[i][j]
        return min(dp[(n - 1) % 2])