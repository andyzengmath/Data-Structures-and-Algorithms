public class LintCode_1325 {
    /**
     * @param m: an Integer
     * @param n: an Integer
     * @return: the bitwise AND of all numbers in [m,n]
     */
    public int rangeBitwiseAnd(int m, int n) {
        // Write your code here
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}