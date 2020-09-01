public class LintCode_551 {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        // dfs
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger ele: nestedList) {
            if (ele.isInteger()) {
                sum += ele.getInteger() * depth;
            } else {
                sum += helper(ele.getList(), depth + 1);
            }
        }
        return sum;
    }
}