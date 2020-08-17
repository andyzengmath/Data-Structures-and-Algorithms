public class LintCode_111 {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 0 ) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int prev = 0, curr = 1;
        for (int i = 0; i < n; i++) {
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}