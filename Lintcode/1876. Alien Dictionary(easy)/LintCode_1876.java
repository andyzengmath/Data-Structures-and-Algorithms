public class LintCode_1876 {
    /** Leet 953
     * @param words: the array of string means the list of words
     * @param order: a string indicate the order of letters
     * @return: return true or false
     */
    public boolean isAlienSorted(String[] words, String order) {
        char[] orderList = order.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < orderList.length; i++) {
            hash[orderList[i] - 'a'] = i;
        }
        return isSorted(words, hash);
    }

    public boolean isSorted(String[] w, int[] hash) {
        for (int i = 0; i < w.length - 1; i++) {
            char[] a = w[i].toCharArray();
            char[] b = w[i + 1].toCharArray();
            for (int j = 0; j < a.length; j++) {
                if (j == b.length) return false;
                if (hash[a[j] - 'a'] < hash[b[j] - 'a']) {
                    break;
                } else if (hash[a[j] - 'a'] == hash[b[j] - 'a']) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}