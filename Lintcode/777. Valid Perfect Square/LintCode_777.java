public class LintCode_777 {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     * Do not use any built-in library function such as sqrt.
     */
    public boolean isPerfectSquare(int num) {
        // write your code here
        long l = 0, r = num;
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (mid * mid <= num) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long ans = l;
        if (l * l < num) {
            ans = r;
        }
        return ans * ans == num;
    }
}