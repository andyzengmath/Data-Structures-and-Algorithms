public class LintCode_33 {
    /* Leet 93%
     * @param n: The number of queens
     * @return: All distinct solutions
     */ 
    private int n;
    private boolean[] col;
    private boolean[] sub;
    private boolean[] main;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        // write your code here
        res = new ArrayList<>();
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
            List<String> board = convert2board(path);
            res.add(board);
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

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num: path) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[num] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}