public class LintCode_1285 {
    /**
     * @param num: an integer
     * @return: whether the integer is a power of 4
     */
    public boolean isPowerOfFour(int num) {
        // Write your code here
        return num > 0 && (num & (num - 1)) == 0 & num % 3 == 1;
    }
}