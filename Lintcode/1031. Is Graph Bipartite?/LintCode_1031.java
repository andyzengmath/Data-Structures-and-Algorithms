public class LintCode_1031 {
    /**
     * @param graph: the given undirected graph
     * @return:  return true if and only if it is bipartite
     */

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;
    public boolean isBipartite(int[][] graph) {
        // Write your code here
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    private void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int colorNext = c == RED? GREEN : RED;
        for (int neighbor: graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, colorNext, graph);
                if (!valid) {
                    return;
                } 
            } else if (color[neighbor] != colorNext) {
                valid = false;
                return;
            }
        }
    }
}