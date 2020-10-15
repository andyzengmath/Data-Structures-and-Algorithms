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

public class LintCode_987 {
    /** Node compareTo val equal case (differential from LeetCode)
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    List<Location> locations;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);

        ans.add(new ArrayList<Integer>());
        
        int prev = locations.get(0).x;
        for (Location loc: locations) {
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }
            ans.get(ans.size() - 1).add(loc.val);
        }
        return ans;
    }

    public void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x - 1, y + 1);
            dfs(node.right, x + 1, y + 1);
        }
    }
}

class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x) {
            return Integer.compare(this.x, that.x);
        } else if (this.y != that.y) {
            return Integer.compare(this.y, that.y);
        } else {
            return 0;
        }
    }
}