public class LintCode_381 {
    /**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here
        int[][] result = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0, x = 0, y = 0;
        
        for (int i = 1; i <= n * n; i++) {
            result[x][y] = i;
            int next_x = x + dx[dir];
            int next_y = y + dy[dir];
            
            if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n || result[next_x][next_y] != 0) {
                dir = (dir + 1) % 4;
                next_x = x + dx[dir];
                next_y = y + dy[dir];
            }
            x = next_x;
            y = next_y;
        }
        return result;
    }
}