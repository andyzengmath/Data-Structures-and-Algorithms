public class LintCode_1314 {
    /**
     * @param n: an integer
     * @return: if n is a power of two
     */
    public boolean isPowerOfTwo(int n) {
        // x & (-x) find the rightmost 1
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
    // x & (x - 1) change the right most 1 to 0
    public boolean isPowerOfTwo(int n) {
        // Write your code here
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }
}