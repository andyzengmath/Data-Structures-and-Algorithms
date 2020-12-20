class LeetCode_140 {
    //Runtime: 2 ms, faster than 99.17% of Java online submissions for Word Break II. Memory Usage: 39 MB, less than 96.77% of Java online submissions for Word Break II.
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        // use dfs to find all break path
        Set<String> wordSet = new HashSet(wordDict);
        int maxLength = getMaxLength(wordSet);
        List<String> results = new ArrayList<>();
        dfsGetResults(s, 0, maxLength, wordSet, memo, new ArrayList<String>(), results);
        return results;
    }
    
    private boolean isPossible(String s, int index, int maxLength, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return true;
        }
        
        memo.put(index, false);
        for (int i = index; i < s.length(); i++) {
            if (i + 1 - index > maxLength) {
                break;
            }
            String word = s.substring(index, i + 1);
            if (!wordSet.contains(word)) {
                continue;
            }
            if (isPossible(s, i + 1, maxLength, wordSet, memo)) {
                memo.put(index, true);
                break;
            }
        }
        return memo.get(index);
    }
    
    private int getMaxLength(Set<String> wordSet) {
        int max = 0;
        for (String word : wordSet) {
            max = Math.max(max, word.length());
        }
        return max;
    }
    
    private void dfsGetResults(String s, int index, int maxLength, Set<String> wordSet, Map<Integer, Boolean> memo, ArrayList<String> path, List<String> results) {
        if (index == s.length()) {
            results.add(String.join(" ", path));
            return;
        }
        
        //pruning
        if (!isPossible(s, index, maxLength, wordSet, memo)) {
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (i + 1 - index > maxLength) {
                break;
            }
            String word = s.substring(index, i + 1);
            if (!wordSet.contains(word)) {
                continue;
            }
            path.add(word);
            dfsGetResults(s, index + word.length(), maxLength, wordSet, memo, path, results);
            path.remove(path.size() - 1);
        }
    }
}