/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class LeetCode_426 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        List<Node> list = new ArrayList<>();
        helper(root, list);
        Node first = list.get(0);
        Node last = list.get(list.size() - 1);
        first.left = last;
        last.right = first;
        return first;
    }
    
    private void helper (Node node, List<Node> list) {
        if (node == null) return;
        helper(node.left, list);
        list.add(node);
        if (list.size() >= 2) {
            Node pre = list.get(list.size() - 2);
            pre.right = node;
            node.left = pre;
        }
        helper(node.right, list);
    }

    // another version using only two nodes
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }
    
    private void helper (Node node) {
        if (node == null) return;
        helper(node.left);
        if (first == null) {
            first = node;
        }
        if (last != null) {
            last.right = node;
            node.left = last;
        }
        last = node;
        helper(node.right);
    }
}