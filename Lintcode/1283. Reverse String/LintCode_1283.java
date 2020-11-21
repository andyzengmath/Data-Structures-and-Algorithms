public class LintCode_1283q {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String reverseString(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}