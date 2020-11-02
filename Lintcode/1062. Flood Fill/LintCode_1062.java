public class LintCode_1062 {
    /**
     * @param image: a 2-D array
     * @param sr: an integer
     * @param sc: an integer
     * @param newColor: an integer
     * @return: the modified image
     */
    int[] dx = {1, 0, 0 ,-1};
    int[] dy = {0, -1, 1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Write your code here
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
        
    }
    
    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length ) {
                dfs(image, mx, my, color, newColor);
            }
        }
        }
        
    }
}