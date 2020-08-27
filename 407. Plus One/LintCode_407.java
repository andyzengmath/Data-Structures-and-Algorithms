public class LintCode_407 {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + add;
            digits[i] = sum % 10;
            add = sum / 10;
            if (add == 0) {
                break;
            }
        }

        if (add == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}