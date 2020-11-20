class LeetCode_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        grid[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int len = q.size();
        int c = 0;
        int[][] dir = {{1,0}, {1,1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};
        int shortest = 1;
        while (!q.isEmpty()) {
            int[] data = q.poll();
            int x = data[0];
            int y = data[1];
            if (x == m - 1 && y == n - 1) return shortest;
            for (int[] d: dir) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == 0) {
                    q.add(new int[]{x1, y1});
                    grid[x1][y1] = 1;
                }
            }
            c++;
            if (c == len) {
                c = 0;
                shortest++;
                len = q.size();
            }
        }
        return -1;
    }
}