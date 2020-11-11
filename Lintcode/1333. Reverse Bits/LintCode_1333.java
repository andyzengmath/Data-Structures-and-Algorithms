public class LintCode_1333 {
    /**
     * @param n: an integer
     * @return: return an integer
     */
    public long reverseBits(long n) {
        // write your code here
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        
        return (long)res;
    }
}