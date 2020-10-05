/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class LintCode_137 {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return node;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        visited.put(node, cloneNode);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}