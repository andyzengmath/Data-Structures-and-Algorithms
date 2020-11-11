public class LintCode_1348 {
    /**
     * @param s: a string
     * @return: return a integer
     */
    public int titleToNumber(String s) {
        // write your code here
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}