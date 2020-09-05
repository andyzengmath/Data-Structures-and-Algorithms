public class LintCode_671 {
    /*
     * @param words: A list of words
     * @return: Return how many different rotate words
     * All words are lowercase.
     */
    public int countRotateWords(List<String> words) {
        // Write your code here
        Set<String> dict = new HashSet<String>();

        for (String w: words) {
            String s = w + w;
            for (int i = 0; i < w.length(); i++) {
                dict.remove(s.substring(i, i + w.length()));
            }
            dict.add(w);
        }

        return dict.size();

    }
}
