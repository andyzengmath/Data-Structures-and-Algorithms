public class LintCode_770 {
    /**
     * @param matrix: an input matrix 
     * @return: nums[0]: the maximum,nums[1]: the minimum
     */
    public int[] maxAndMin(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[0] = Math.max(result[0], matrix[i][j]);
                result[1] = Math.min(result[1], matrix[i][j]);
            }
        }

        return result;
    }
}