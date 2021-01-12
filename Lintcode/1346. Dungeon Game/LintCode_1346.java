public class LintCode_1346 {
    /**
     * @param dungeon: a 2D array
     * @return: return a integer
     */
    int inf = Integer.MAX_VALUE;
    int[][] dp;
    int rows, cols;
    
    public int getMinHealth(int currCell, int nextRow, int nextCol) {
        if (nextRow >= this.rows || nextCol >= this.cols) return inf;
        int nextCell = this.dp[nextRow][nextCol];
        return Math.max(1, nextCell - currCell);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        this.rows = dungeon.length;
        this.cols = dungeon[0].length;
        this.dp = new int[rows][cols];
        for (int[] arr: this.dp) {
            Arrays.fill(arr, this.inf);
        }
        int currCell, rightHealth, downHealth, nextHealth, minHealth;
        for (int row = this.rows - 1; row >= 0; --row) {
            for (int col = this.cols - 1; col >= 0; --col) {
                currCell = dungeon[row][col];
                rightHealth = getMinHealth(currCell, row, col + 1);
                downHealth = getMinHealth(currCell, row + 1, col);
                nextHealth = Math.min(rightHealth, downHealth);
                
                if (nextHealth != inf) {
                    minHealth = nextHealth;
                } else {
                    minHealth = currCell >= 0 ? 1: 1 - currCell;
                }
                this.dp[row][col] = minHealth;
            }
        }
        return this.dp[0][0];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}