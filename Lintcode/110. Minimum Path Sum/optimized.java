public class optimized {
    public int minPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length) {
            return 0;
        }

        int m = A.length, n = A[0].length;
        int[] f = new int[n];
        Array.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        for (int i = 0; i < m; i++) {
            f[0] += grid[i][0]
            for (int j = 1; j < n; j++) {
                f[j] = Math.min(f[j-1], f[j]) + grid[i][j];
            }
        }
        return f[n-1];
}