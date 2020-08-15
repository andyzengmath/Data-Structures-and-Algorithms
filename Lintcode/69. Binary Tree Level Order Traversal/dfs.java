import java.util.Currency;

public class dfs {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            result.add(level);
            maxLevel++;
        }

        return result;
    }

    private void dfs(TreeNode root, List<Integer> level, int curLevel, int maxLevel) {
        if (root == null ||| curLevel > maxLevel) {
            return;
        }
        if (curLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curLevel + 1, maxLevel);
        dfs(root.right, level, curLevel + 1, maxLeverl);
    }
}