public class LintCode_278 {
    /**
     * @param screen: a two-dimensional array of colors
     * @param x: the abscissa of the specified point
     * @param y: the ordinate of the specified point
     * @param newColor: the specified color
     * @return: Can it be filled
     */
    public boolean paintFill(int[][] screen, int x, int y, int newColor) {
        // write your code here.
        if (screen[x][y] == newColor) {
            return false;
        }
        return paintFill(screen, x, y, screen[x][y], newColor);
    }

    public boolean paintFill(int[][] screen, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= screen.length || y < 0 || y > screen[0].length) return false;
        if (screen[x][y] == oldColor) {
            screen[x][y] = newColor;
            paintFill(screen, x - 1, y, oldColor, newColor);
            paintFill(screen, x + 1, y, oldColor, newColor);
            paintFill(screen, x, y - 1, oldColor, newColor);
            paintFill(screen, x, y + 1, oldColor, newColor);
        }

        return true;
    }
}