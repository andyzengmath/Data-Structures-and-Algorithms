public class LintCode_829 {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        Map<Character, String> mapping = new HashMap<>();
        Set<String> used = new HashSet<>();
        return isMatch(pattern, str, mapping, used);
    }

    private boolean isMatch(String pattern, String str, Map<Character, Character> mapping, Set<String> used) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        Char ch = pattern.charAt(0);
        if (mapping.containsKey(ch)) {
            String word = mapping.get(ch);
            if (!str.startswith(word)) {
                return false;
            }
            return isMatch(pattern.substring(1), str.substring(word.length()), mapping, used);
        }

        for (int len = 0; len < str.length(); len++) {
            String word = str.substring(0, len + 1);
            if (used.contains(word)) {
                continue;
            }
            mapping.put(ch, word);
            used.add(word);
            if (isMatch(pattern.substring(1), str.substring(word.length()), mapping, used)) {
                return true;
            }
            used.remove(word);
            mapping.remove(ch);
        }
        return false;

    }


}