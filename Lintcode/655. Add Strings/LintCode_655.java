public class LintCode_655 {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        String result = "";
        int m = num1.length() - 1, n = num2.length() - 1, flag = 0;
        while (m >=0 || n >= 0) {
            int a, b;
            if (m >= 0) {
                a = num1.charAt(m--) - '0';
            } else {
                a = 0;
            }

            if (n >= 0) {
                b = num2.charAt(n--) - '0';
            } else {
                b = 0;
            }
            int sum = a + b + flag;
            result = (char)(sum % 10 + '0') + result;
            flag = sum / 10;
        }

        return flag == 1 ? "1" + result : result;

    }
}
