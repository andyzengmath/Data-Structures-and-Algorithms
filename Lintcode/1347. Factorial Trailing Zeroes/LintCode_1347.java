public class LintCode_1347 {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int trailingZeroes(int n) {
        // write your code here
        int count = 0;
        int currMultiple = 5;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}