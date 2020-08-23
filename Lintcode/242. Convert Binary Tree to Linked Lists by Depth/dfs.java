public class dfs {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // dfs
        List<ListNode> result = new List<ListNode>();
        dfs(root, 1, result);
        return result;
    }

    void dfs(TreeNode root, int depth, List<ListNode> result) {
        if (root == null) {
            return;
        }
        ListNode node = new ListNode(root.val);
        if (result.size() < depth) {
            result.add(node);
        } else {
            node.next = result.get(depth - 1);
            result.set(depth - 1, node);
        }
        dfs(root.right, depth + 1, result);
        dfs(root.left, depth + 1, result);
    }
}