public class LintCode_374 {
    /** Leetcode-54
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        // write your code here
        List<Integer> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int dir = 0;

        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            results.add(matrix[x][y]);
            matrix[x][y] = 0;
            int next_x = x + dx[dir];
            int next_y = y + dy[dir];

            if (next_x < 0 || next_x >= matrix.length || next_y < 0
                || next_y >= matrix[0].length || matrix[next_x][next_y] == 0) {
                    dir = (dir + 1) % 4;
                    next_x = x + dx[dir];
                    next_y = y + dy[dir];
                }
            x = next_x;
            y = next_y;
        }
        return results;

    }
}