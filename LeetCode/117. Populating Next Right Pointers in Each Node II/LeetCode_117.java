/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class LeetCode_117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null;
            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                if (i != 0) {
                    last.next = currNode;
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                last = currNode;
            }
        }
        return root;
    }
}