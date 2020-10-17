public class LintCode_654 {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        iint n = A.length;
        int m = B[0].length;
        int k = A[0].length;
        int[][] C = new int[n][m];

        List<List<Integer>> col = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            col.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (B[i][j] !=0) {
                    col.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int t: col.get(j)) {
                C[i][t] += A[i][j] * B[j][t];
                }
            }
        }
        return C;
    }
}