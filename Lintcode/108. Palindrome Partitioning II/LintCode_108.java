public class LintCode_108 {
    /** Leet 137
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        // write your code here
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        for (int i = 1; i < len; i++) {
            if (checkPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }


}