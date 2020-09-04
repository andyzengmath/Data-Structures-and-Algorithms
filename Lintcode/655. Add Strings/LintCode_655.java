public class LintCode_655 {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        String result = "";
        int m = num1.length(), n = num2.length, flag = 0;
        while (m - 1 >=0 || n - 1 >= 0) {
            int a, b;
            if (i >= 0) {
                a = num1.charAt(i--) - '0';
            } else {
                a = 0;
            }

            if (j >= 0) {
                b = num2.charAt(j--) - '0';
            } else {
                b = 0;
            }
            int sum = a + b + flag;
            result = (char)(sum % 10 + '0') + result;
            flag = sum / 10;
        }

        return flag == 1 ? "1" + res : res;

    }
}
