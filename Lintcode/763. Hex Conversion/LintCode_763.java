public class LintCode_763 {
    /**
     * @param n: a decimal number
     * @param k: a Integer represent base-k
     * @return: a base-k number
     */
    public String hexConversion(int n, int k) {
        // 
        String res = "";
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            int t = n % k;
            char c = ' ';
            if (t <= 9) {
                c = (char)('0' + t);
            } else {
                c = (char)('A' + (t - 10));
            }
            res = c + res;
            n /= k;
        }

        return res;
    }
}
