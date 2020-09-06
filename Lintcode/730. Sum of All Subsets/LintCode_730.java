public class LintCode_730 {
    /**
     * @param n: the given number
     * @return: Sum of elements in subsets
     */
    public int subSum(int n) {
        // write your code here
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum * (int)Math.pow(2, n - 1);
    }
}
