public class LintCode_178 {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour: adjacencyList.get(node)) {
                if (parent.get(node) == neighbour) {
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                stack.push(neighbour);
                parent.put(neighbour, node);
            }

        }
        return parent.size() == n;
    }
}