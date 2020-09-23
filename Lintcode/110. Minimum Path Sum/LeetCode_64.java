class LeetCode_64:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        dp = [0] + [sys.maxsize] * (n - 1)
            
        for i in range(m):
            dp[0] += grid[i][0]
            for j in range(1, n):
                dp[j] = min(dp[j - 1], dp[j]) + grid[i][j]
                
        return dp[n - 1]
                
        