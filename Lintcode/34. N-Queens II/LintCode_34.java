public class LintCode_34 {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    private int n;
    private boolean[] col;
    private boolean[] sub;
    private boolean[] main;
    private int res;

    public int totalNQueens(int n) {
        // write your code here
        res = 0;
        if (n == 0) {
            return res;
        }
        this.n = n;
        this.col = new boolean[n];
        this.sub = new boolean[2 * n - 1];
        this.main = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !sub[row + j] && !main[row - j + n - 1]) {
                path.addLast(j);
                col[j] = true;
                sub[row + j] = true;
                main[row - j + n - 1] = true;
                
                dfs(row + 1, path);

                col[j] = false;
                sub[row + j] = false;
                main[row - j + n - 1] = false;
                path.removeLast();
            }
        }
    }
}