class LeetCode_139 {
    // slow!
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        Set<String> dict = new HashSet(wordDict);
        boolean[] dp = new boolean[len];
        dp[0] = dict.contains(s.charAt(0));
        for (int r = 0; r < len; r++) {
            if (dict.contains(s.substring(0, r + 1))) {
                dp[r] = true;
            }
            for (int l = 0; l < r; l++) {
                if (dp[l] && dict.contains(s.substring(l + 1, r + 1))) {
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    //optimized version
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return true;
        int maxLength = 0;
        for (String word: wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        fot (int i = 1; i <= n; i++) {
            if (i < l) {
                break;
            }
            if (!dp[i - l]) continue;
            String word = s.substring(i - l, i);
            if (dict.contains(word)) {
                dp[i] = true;
                break;
            }
        }
        return dp[n];
    }
}