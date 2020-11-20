class NumMatrix {

    private int[][] prefixSum = null;
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] + matrix[i][j] - prefixSum[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int n = matrix.length;
        int m = matrix[0].length;
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row + 1; i <= n; i++) {
            for (int j = col + 1; j <= m; j++) {
                prefixSum[i][j] += delta;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */