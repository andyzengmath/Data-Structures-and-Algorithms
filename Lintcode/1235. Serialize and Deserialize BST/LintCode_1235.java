/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class LintCode_1235 {
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) return "{}";
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return queueToString(queue);
    }
    
    private String queueToString(List<TreeNode> queue) {
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        List<String> items = new ArrayList<>();
        for (TreeNode node: queue) {
            if (node == null) {
                items.add("#");
            } else {
                items.add("" + node.val);
            }
        }
        
        return "{" + String.join(",", items) + "}";
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }
        
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}