public class LintCode_120 {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);

        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);

        int len = 1;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return len;
                    }
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }

        return 0;        
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }


    // JiuZhang double BFS version
    public int ladderLength(String start, String end, Set<String> wordSet) {
        if (start.equals(end)) {
            return 1;
        }
        HashMap<String, Set<String>> graph;
        Queue<String> forwardQueue = new LinkedList<String>();
        Queue<String> backwardQueue = new LinkedList<String>();
        Set<String> forwardSet = new HashSet<String>();
        Set<String> backwardSet = new HashSet<String>();
        
        wordSet.add(start);
        wordSet.add(end);
        graph = constructGraph(wordSet);
        forwardQueue.offer(start);
        backwardQueue.offer(end);
        forwardSet.add(start);
        backwardSet.add(end);

        int distance = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            if (extendQueue(graph, forwardQueue, forwardSet, backwardSet)) {
                return distance;
            }
            distance++;
            if (extendQueue(graph, backwardQueue, backwardSet, forwardSet)) {
                return distance;
            }
        }
        return -1;
    }

    boolean extendQueue(HashMap<String, Set<String>> graph, Queue<String> queue, Set<String> visited, Set<String> oppositeVisited) {
        int queueLength = queue.size();
        for (int i = 0; i < queueLength; i++) {
            String word = queue.poll();
            Set<String> nextWordSet = graph.get(word);
            for (String nextWord: nextWordSet) {
                if (visited.contains(nextWord)) {
                    continue;
                }
                if (oppositeVisited.contains(nextWord)) {
                    return true;
                }
                queue.offer(nextWord);
                visited.add(nextWord);
            }
        }
        return false;
    }

    HashMap<String, Set<String>> constructGraph(Set<String> wordSet) {
        HashMap<String, Set<String>> graph = new HashMap<String, Set<String>>();
        for (String word: wordSet) {
            graph.put(word, getNextWords(word, wordSet));
        }
        return graph;
    }

    Set<String> getNextWords(String word, Set<String> wordSet) {
        Set<String> nextWordSet = new HashSet<String>();
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i + 1);
            char[] chars = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
            for (int j = 0; j < 26; j++) {
                if (word.charAt(i) == chars[j]) {
                    continue;
                }
                String nextWord = prefix + chars[j] + suffix;
                if (wordSet.contains(nextWord)) {
                    nextWordSet.add(nextWord);
                }
            }
        }
        return nextWordSet;
    }
}