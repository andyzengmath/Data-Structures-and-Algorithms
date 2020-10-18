public class LintCode_775 {
    /**
     * @param words: a list of unique words
     * @return: all pairs of distinct indices
     */

    List<String> wordRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        // Write your code here
        int n = words.length;
        for (String word: words) {
            wordRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; i++) {
            indices.put(wordRev.get(i), i);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) continue;
            for (int j = 0; j <= m; j++) {
                if (isPalidrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        res.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalidrome(word,0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        res.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return res;
    }
    public boolean isPalidrome(String s, int left, int right) {
        int len = (right - left + 1);
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }
    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), - 1);
    }
}