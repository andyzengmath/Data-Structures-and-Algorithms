import java.util.Queue;

import tree_height.TreeHeight.Node;

public class treeHeightBfs {
    public int getHeight(Node root) {
        Queue<org.w3c.dom.Node> q = new LinkedList<Node>();
        int height = 0;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                height++;
            } else {
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
        return height;
    }
}