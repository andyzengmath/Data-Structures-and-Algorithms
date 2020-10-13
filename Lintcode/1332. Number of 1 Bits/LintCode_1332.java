public class LintCode_1332 {
    /**
     * @param n: an unsigned integer
     * @return: the number of ’1' bits
     */
    public int hammingWeight(int n) {
        // write your code here
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= n - 1;
        }
        return sum;
    }
}