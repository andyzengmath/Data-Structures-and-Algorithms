public class LintCode_905 {
    /**
     * @param nestedList: a list of NestedInteger
     * @return: the sum
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // Write your code here.
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int preSum = 0;
        int result = 0;

        Queue<NestedInteger> queue = new LinkedList<>(nestedList);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger n = queue.poll();
                if (n.isInteger()) {
                    levelSum += n.getInteger();
                } else {
                    queue.addAll(n.getList());
                }
            }
            preSum += levelSum;
            result += preSum;
        }
        return result;
        
    }
}