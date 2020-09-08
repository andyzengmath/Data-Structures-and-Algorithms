public class LintCode_797 {
    /**
     * @param target: the destination
     * @return: the minimum number of steps
     * 首先一次相加直到和大于目标，比较差值，如果是偶数，说明只需要将几个数又加号变为减号（里外里2倍，所以一定是偶数），
     * 若是奇数，就要想办法制造1，减去一个奇数加上下一个偶数即可，所以如果当前n是个奇数，就需要加上下一个偶数，
     * 如果当前是个偶数就需要减去下一个奇数，加上下一个偶数
     */
    public int reachNumber(int target) {
        // Write your code here
        long t = Math.abs(target);
        long n = (long) Math.ceil((-1.0 + Math.sqrt(1 + 8.0 * t)) / 2);
        long sum = n * (n + 1) / 2;
        long diff = sum - target;
        if (diff == 0) {
            return (int)n;
        } else if (diff % 2 == 0) {
            return (int)n;
        } else if ((diff + n + 1) % 2 == 0) {
            return (int)n + 1;
        } else {
            return (int)n + 2;
        }
    }
}