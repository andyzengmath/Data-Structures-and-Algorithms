public class LintCode_413 {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        int reversed = 0;
        while (n != 0) {
            int temp = reversed * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed) {
                return 0; // check 32-bit integer overflow
            }
            reversed = temp;
        }
        return reversed;
    }
}