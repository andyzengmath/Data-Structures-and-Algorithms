public class LintCode_28 {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     * O(log(n) + log(m)) time
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1;

        if (target < matrix[0][0] || target > matrix[n][m]) {
            return false;
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[m / mid][m % mid] == target) {
                return true;
            } else if (matrix[m / mid][m % mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (matrix[left / mid][left % mid] == target) {
            return true;
        }
        return false;
    }
}