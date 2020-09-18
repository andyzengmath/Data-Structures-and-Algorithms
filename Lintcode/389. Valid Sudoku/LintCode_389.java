import java.util.HashSet;

public class LintCode_389 {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        Set<Character> used = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            used.clear();
            for (int col = 0; col < 9; col++) {
                if (! checkValid(board[row][col], used)) {
                    return false;
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            used.clear();
            for (int row = 0; row < 9; row++) {
                if (! checkValid(board[row][col], used)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                used.clear();
                for (int row = i * 3; row < i * 3 + 3; row++) {
                    for (int col = j * 3; col < j * 3 + 3; col ++) {
                        if (! checkValid(board[row][col], used)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean checkValid(char c, Set<Character> used) {
        if (c == '.') {
            return true;
        }
        if (used.contains(c)) {
            return false;
        }
        used.add(c);
        return true;
    }
}