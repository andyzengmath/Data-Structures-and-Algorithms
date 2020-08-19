public class LintCode_158 {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     * Two strings are anagram if they can be the same after change the order of characters.
     * O(n) time, O(1) extra space
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] countS = new int[256];

        for (char c: s.toCharArray()) {
            countS[c]++;
        }
        for (char c: t.toCharArray()) {
            countS[c]--;
       
        }
        for (int i = 0; i < countS.length; i++) {
            if (countS[i] != 0) {
                return false;
            }
        }
        return true;
    }
}