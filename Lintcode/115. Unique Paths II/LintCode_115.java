public class LintCode_115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                matrix[i][0] = 0;
            } else {
                matrix[i][0] = matrix[i - 1][0];
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                matrix[0][j] = 0;
            } else {
                matrix[0][j] = matrix[0][j - 1];
            }
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1]; 
                }
                
            }
        } 

        return matrix[m - 1][n - 1];

    }
}