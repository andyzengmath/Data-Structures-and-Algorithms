public class LintCode_812 {
    /**
     * @param words: the words
     * @param S: the string
     * @return: the string with least number of tags
     */
    public String boldWords(String[] words, String S) {
        // Write your code here
        int[] s = new int[S.length() + 1];
        for (String w: words) {
            int i = 0;
            while ((i = S.indexOf(w, i)) >= 0) {
                s[i]++;
                s[i + w.length()]--;
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int pre = 0, sum = 0;
        for (int i = 0; i <= S.length(); i++) {
            sum += s[i];
            if (sum > 0 && pre == 0) sb.append("<b>");
            if (sum == 0 && pre > 0) sb.append("</b>");
            if (i < S.length()) sb.append(S.charAt(i));
            pre = sum;
        }
        return sb.toString();
    }
}