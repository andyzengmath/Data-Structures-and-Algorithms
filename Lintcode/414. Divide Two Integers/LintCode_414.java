public class LintCode_414 {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        boolean is_negative = false;

        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            is_negative = true;
        }

        long ans = 0;
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);
        while (dividend1 >= divisor1) {
            long temp = divisor1;
            long cnt = 1;
            while (dividend1 >= temp) {
                dividend1 -= temp;
                ans += cnt;
                cnt <<= 1;
                temp <<= 1;
            }
        }
        if (is_negative) {
            ans = -ans;
        }

        long INT_MIN = - (1 << 31);
        long INT_MAX = (1 << 31) - 1;
        if (ans < INT_MIN || ans > INT_MAX) {
            ans = INT_MAX;
        }

        return (int) ans;

    }
}