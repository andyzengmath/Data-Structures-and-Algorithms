public class another {
    public int countRotateWords(List<String> words) {
        if (words == null || words.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();

        for (String word: words) {
            boolean exist = false;
            for (int i = 0; i < word.length(); i++) {
                String cur = word.substring(i, word.length()) + word.substring(0, i);
                if (set.contains(cur)) {
                    exist = true;
                    break;
                }
            }
            if (exist == false) {
                set.add(word);
            }
        }
        return set.size();
    }
}
