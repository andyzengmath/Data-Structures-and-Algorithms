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

class LeetCode_116 {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                if (i < size - 1) {
                    Node nextNode = queue.peek();
                    currNode.next = nextNode;
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
    }
}