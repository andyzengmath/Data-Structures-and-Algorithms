public class bfs2q {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<TreeNode> q1 = new ArrayList<TreeNode>();
        List<TreeNode> q2 = new ArrayList<TreeNode>();

        q1.add(root);
        while (q1.size() != 0) {
            List<Integer> level = new ArrayList<Integer>();
            q2.clear();
            for (int i = 0; i < q1.size(); i++) {
                TreeNode = q1.get(i);
                level.add(node.val);
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            List<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;

            result.add(level);
        }

        return result;


        


    }
}