public class LintCode_510 {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);

        int max = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            //height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == true) {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                    
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == true) {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }
        return max;
    
    }
}