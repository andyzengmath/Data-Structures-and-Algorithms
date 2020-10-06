public class LintCode_107 {
    /**Leet 139
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        boolean[] dp = new boolean[len];
        dp[0] = wordSet.contains(s.charAt(0));
        for (int r = 0; r < len; r++) {
            if (wordSet.contains(s.substring(0, r + 1))) {
                dp[r] = true;
            }
            for (int l = 0; l < r; l++) {
                if (dp[l] && wordSet.contains(s.substring(l + 1, r + 1))) {
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}