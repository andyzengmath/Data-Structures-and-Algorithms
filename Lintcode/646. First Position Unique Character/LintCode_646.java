pulbic class LintCode_646 {
    /**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // hash
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charCount .containsKey(c)) {
                charCount.put(c, 0);
            }
            charCount.put(c, (int)charCount.get(c) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((int)charCount.get(c) == 1) {
                return i;
            }
        }

        return -1;


    }
}