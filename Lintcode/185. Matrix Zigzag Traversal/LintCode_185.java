public class LintCode_185 {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0] == 0) {
            return null;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[n * m];
        int count = 0;

        for (int diagSum = 0; diagSum < m + n - 1; diagSum++) {
            if (diagSum % 2 == 1) {
                for (int j = 0; j < m; j++) {
                    if (i - j >= 0 && i - j < n) {
                        result[count++] = matrix[j][i-j];    
                    }
                }
            } else {
                for (int j = i; j >= 0; j--) {
                    if (j < m && i - j > 0 && i - j < n) {
                        result[count++] = matrix[j][i-j];    
                    }
                }
            }
        }
        return result;
    }
}