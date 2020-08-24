public class LintCode_260 {
    /**
     * @param matrix: a matrix
     * @return: return true if same.
     */
    public boolean judgeSame(int[][] matrix) {
        // write your code here.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int n = matrix.length;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                };
            }
        }
        return true;
    }
}