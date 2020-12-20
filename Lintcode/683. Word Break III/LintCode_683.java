public class LintCode_683 {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        Set<String> lowerDict = new HashSet<>();
        int maxLength = initialize(dict, lowerDict);
        return memoSearch(s.toLowerCase(), 0, maxLength, lowerDict, new HashMap<Integer, Integer>());
    }

    private int memoSearch(String s, int index, int maxLength, Set<String> lowerDict, Map<Integer, Integer> memo) {
        if (index == s.length()) {
            return 1;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        memo.put(index, 0);
        for (int i = index; i < s.length(); i++) {
            if (i - index + 1 > maxLength) {
                break;
            }
            String word = s.substring(index, i + 1);
            if (!lowerDict.contains(word)) {
                continue;
            }
            memo.put(index, memo.get(index) + memoSearch(s, i + 1, maxLength, lowerDict, memo));
        }
        return memo.get(index);
    }

    private int initialize(Set<String> dict, Set<String> lowerDict) {
        int maxLength = 0;
        for (String word: dict) {
            maxLength = Math.max(maxLength, word.length());
            lowerDict.add(word.toLowerCase());
        }
        return maxLength;
    }
}