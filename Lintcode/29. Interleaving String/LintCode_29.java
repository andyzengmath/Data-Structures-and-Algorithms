public class LintCode_29 {
    /** O(n2) time or better
     * Leet 97
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int n = s1.length(), m = s2.length(), l = s3.length();
        if (n + m != l) {
            return false;
        }
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        
        for (int j = 1; j <= m && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int k = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
        }
        
        return dp[n][m];
    }
}