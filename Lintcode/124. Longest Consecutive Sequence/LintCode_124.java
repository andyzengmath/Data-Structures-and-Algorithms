import java.util.Map;

public class LintCode_124 {
    /**
     * @param num: A list of integers
     * @return: An integer
     * Your algorithm should run in O(n) complexity. 
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }

        Map<Integer, Integer> list = new HashMap<>();

        int maxLength = 0;
        for (int n: num) {
            if (list.containsKey(n)) {
                continue;
            }
            int leftCount = 0, rightCount = 0;
            if (list.containsKey(n - 1)) {
                leftCount = list.get(n - 1);
            } 
            if (list.containsKey(n + 1)) {
                rightCount = list.get(n + 1);
            }
            int count = leftCount + rightCount + 1;
            maxLength = Math.max(maxLength, count);
            list.put(n, count);
            list.put(n - leftCount, count);
            list.put(n + rightCount, count);
        }

        return maxLength;
    }
}