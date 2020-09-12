public class SortByRow {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return 0;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;

        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row: rows) res.append(rows);
        return res.toString();
    }
}