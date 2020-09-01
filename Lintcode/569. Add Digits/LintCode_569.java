public class LintCode_569 {
    /**
     * @param num: a non-negative integer
     * @return: one digit
     * Could you do it without any loop/recursion in O(1) runtime?
     */
    public int addDigits(int num) {
        // write your code here
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;

    }
}