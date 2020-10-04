

public class Solution {
    /* not passed
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
     
    public class Pair {
        private String key;
        private int val;
        public Pair (String str, int val) {
            this.key = str;
            this.val = val;
        }
        
        public String getKey() {
            return this.key;
        }
        
        public int getValue() {
            return this.val;
        }
    }
    
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        int L = start.length();
        Map<String, List<String>> allDict = new HashMap<>();
        dict.forEach(
            word ->{
                for (int i = 0; i < L; i++) {
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                    List<String> transform = allDict.getOrDefault(newWord, new ArrayList<>());
                    transform.add(word);
                    allDict.put(newWord, transform);
                }
            }
        );

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(start, true);
        while (!queue.isEmpty()) {
            Pair node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                for (String adjacentWord: allDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(end)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }

        }
        return 0;
    }
}