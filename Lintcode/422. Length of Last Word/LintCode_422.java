public class LintCode_422 {
    /**
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim;
        int last = s.length() - 1;
        while (last >=0 && s.charAt(last) != ' ') {
            index--;
        }

        return s.length() - 1 - last;
    }
}