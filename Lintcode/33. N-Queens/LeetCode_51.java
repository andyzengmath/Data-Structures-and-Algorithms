class LeetCode_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    private void search(List<List<String>> results, List<Integer> cols, int n) {
        if (cols.size() == n) {
            results.add(Draw(cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == col) return false;
            if (row + col == rowIndex + cols.get(rowIndex)) return false;
            if (row - col == rowIndex - cols.get(rowIndex)) return false;
        }
        return true;
    }

    private List<String> Draw(List<Integer> cols) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            result.add(sb.toString());
        }
        return result;
    }


    //optimized
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        search(results, new ArrayList<Integer>(), n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return results;
    }

    private void search(List<List<String>> results, List<Integer> cols, int n, boolean[] colUsed, boolean[] sumUsed, boolean[] diffUsed) {
        int rowIndex = cols.size();
        if (rowIndex == n) {
            results.add(Draw(cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(rowIndex, colIndex, colUsed, sumUsed, diffUsed)) {
                continue;
            }
            cols.add(colIndex);
            colUsed[colIndex] = true;
            sumUsed[colIndex + rowIndex] = true;
            diffUsed[rowIndex - colIndex + n - 1] = true;
            search(results, cols, n, colUsed, sumUsed, diffUsed);
            colUsed[colIndex] = false;
            sumUsed[colIndex + rowIndex] = false;
            diffUsed[rowIndex - colIndex + n - 1] = false;
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(int row, int col, boolean[] colUsed, boolean[] sumUsed, boolean[] diffUsed) {
        if (colUsed[col]) return false;
        if (sumUsed[row + col]) return false;
        if (diffUsed[row - col + colUsed.length - 1]) return false;
        return true;
    }

    private List<String> Draw(List<Integer> cols) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            result.add(sb.toString());
        }
        return result;
    }
}