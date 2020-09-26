public class LintCode_430 {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n = ch1.length;
        int m = ch2.length;
        if (n != m) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][1] = ch1[i] == ch2[j];
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k <= len - 1; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i + k][j][len - k] && dp[i][j + len - k][k]) {
                            dp[i][j][len] = true;
                            break;
                        }

                    }
                }
            }
        }
        return dp[0][0][n];
    }
}