public class LintCode_118 {
    /** Leet 115
     * @param S: A string
     * @param T: A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S.length() == 0) return 0; 
        if (T.length() == 0) return 1; 
        
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < T.length() + 1; j++) {
                if (T.charAt(j - 1) == S.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}