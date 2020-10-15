public class LintCode_77 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String str1, String str2) {
        // write your code here
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return 0;

        int[] dp = new int[str2.length() + 1];
        int temp = 0;
        for (int i = 1; i <= str1.length(); i++) {
            int last = 0;
            for (int j = 1; j <= str2.length(); j++) {
                temp = dp[j];
                if (str2.charAt(j - 1) == str1.charAt(i - 1)) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                last = temp;
            }
        }
        return dp[str2.length()];
    }
}