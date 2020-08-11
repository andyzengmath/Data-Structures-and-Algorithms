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
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1;

        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid / m][mid % m] == target) {
                return true;
            } else if (matrix[mid / m][mid % m] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (matrix[left / m][left % m] == target) {
            return true;
        }
        return false;
    }
}