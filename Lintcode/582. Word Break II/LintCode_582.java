public class LintCode_582 {
    /* Leet 140 too slow!!!
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        int len = s.length();
        boolean[] dp = new boolean[len];
        
        dp[0] = wordDict.contains(s.charAt(0));
        for (int r = 0; r < len; r++) {
            if (wordDict.contains(s.substring(0, r + 1))) {
                dp[r] = true;
                //continue;
            }
            for (int l = 0; l < r; l++) {
                if (dp[l] && wordDict.contains(s.substring(l + 1, r + 1))) {
                    dp[r] = true;
                    break;
                }
            }
        }
        if (dp[len - 1]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s, len - 1, wordDict, res, queue, dp);
            return res;
        }
        return res;
    }
    private void dfs(String s, int end, Set<String> wordDict, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if (wordDict.contains(s.substring(0, end + 1))) {
            queue.addFirst(s.substring(0, end + 1));
            StringBuilder sb = new StringBuilder();
            for (String word: queue) {
                sb.append(word);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            queue.removeFirst();
        }
        for (int i = 0; i < end; i++) {
            if (dp[i]) {
                String suffix = s.substring(i + 1, end + 1);
                if (wordDict.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s, i, wordDict, res, queue, dp);
                    queue.removeFirst();
                }
            }
        }
    }
}