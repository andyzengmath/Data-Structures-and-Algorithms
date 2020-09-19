public class LintCode_656{
    /** LeetCode_43
     * O(mn) O(m+n)
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >=0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        
        int index = ans[0] == 0 ? 1 : 0;

        StringBuilder res = new StringBuilder();
        while (index < m + n) {
            res.append(ans[index]);
            index++;
        }
        return res.toString();
    }
}