public class LintCode_828 {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        HashMap index = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!index.containsKey(c)) {
                index.put(c, i);
            }
            if (!index.containsKey(w)) {
                index.put(w, i);
            }
            if (index.get(c) != index.get(w)) {
                return false;
            }
        }
        return true;
    }
}