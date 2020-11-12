
public class Trie {
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here O(m) search O(m) space
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)) {
                node.put(currChar, new TrieNode());
            }
            node = node.get(currChar);
        }
        node.setEnd();
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            if (node.containsKey(currLetter)) {
                node = node.get(currLetter);
            } else {
                return null;
            }
        }
        return node;
    }
    public boolean search(String word) {
        // write your code here
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[R];
        }
        
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
    }