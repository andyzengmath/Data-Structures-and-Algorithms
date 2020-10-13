public class WordDictionary {
    /* LeetCode 211
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    class TrieNode {
        TrieNode[] children;
        boolean flag;
        
        public TrieNode() {
            children = new TrieNode[26];
            flag = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }

    public void addWord(String word) {
        // write your code here
        char[] ch = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < ch.length; i++) {
            if (cur.children[ch[i] - 'a'] == null) {
                cur.children[ch[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[ch[i] - 'a'];
        }
        cur.flag = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return searchHelp(word, root);

    }

    private boolean searchHelp(String word, TrieNode root) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (searchHelp(word.substring(i + 1), cur.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }

            if (cur.children[array[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[array[i] - 'a'];
        }
        return cur.flag;
    }
}