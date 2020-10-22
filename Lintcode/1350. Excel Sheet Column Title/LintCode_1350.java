public class LintCode_1350 {
    /** leet 168
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        // write your code here
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int rem = n % 26;
            sb.insert(0, (char)('A' + rem));
            n /= 26;
        }
        return sb.toString();
    }
}