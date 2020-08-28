class UnionFind {
    private int[] parent;
    private int[] rank;
    int count;

    private int find(int i) {
        if (i < 0 || i > parent.length) return -1;

        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = 0;
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a == root_b) {
            return;
        }
        if (rank[root_a] < rank[root_b]) {
            parent[root_a] = root_b;
        } else if (rank[root_a] > rank[root_b]) {
            parent[root_b] = parent[root_a];
        } else {
            parent[root_b] = root_a;
            rank[root_a]++;
        }
        count--;
    }
}

public class UnionFind {
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!grid[i][j]) continue;

                int id = i * m + j;
                uf.count++;

                if (j + 1 < m && grid[i][j + 1]) uf.union(id, id + 1);
                if (i + 1 < n && grid[i + 1][j]) uf.union(id, id + m);
            }
        }
        return uf.count;
    }
}