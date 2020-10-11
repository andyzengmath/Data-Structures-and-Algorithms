public class LintCode_640 {
    /** LeetCode 161
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) >= 2) return false;

        if (m > n) return isOneEditDistance(t, s);
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return m != n;
    }
}