public class LintCode_1020 {
    /**
     * @param graph: a 2D array
     * @return: all possible paths from node 0 to node N-1
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // Write your code here
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(0);
        dfs(0, path, res, graph);
        return res;
    }
    
    private void dfs(int n, List<Integer> path, List<List<Integer>> res, int[][] graph) {
        if (n == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        int[] currNode = graph[n];
        for (int node: currNode) {
            path.add(node);
            dfs(node, path, res, graph); //node here use node rather than n - 1
            path.remove(path.size() - 1);
        }
    }
}